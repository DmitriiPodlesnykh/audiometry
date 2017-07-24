package com.vsu.amm.medframe.component.sound;

import com.vsu.amm.medframe.model.dto.DevicePointElement;
import com.vsu.amm.medframe.model.entity.Device;
import com.vsu.amm.medframe.enums.BaseIntensityLevel;
import com.vsu.amm.medframe.enums.Frequency;
import com.vsu.amm.medframe.service.DevicePointService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SoundPointsGenerator {

    private static final Logger LOGGER = Logger.getLogger(SoundPointsGenerator.class);

    @Autowired
    private DevicePointService devicePointService;

    public Collection<DevicePointElement> generatePoints(DevicePointElement startPoint) {
        Collection<DevicePointElement> points = new ArrayList<DevicePointElement>();

        double amplitudeAtZeroIntensityLevel = startPoint.getSoundValue();

        for (BaseIntensityLevel intensityLevel : BaseIntensityLevel.values()) {
            if (intensityLevel.equals(BaseIntensityLevel.ZERO_INTENSITY_VALUE)) {
                generatePointsWithSomeAmplitude(points, amplitudeAtZeroIntensityLevel, intensityLevel);
            } else {
                double currentAmplitude = SoundUtils.createAmplitudeValue(intensityLevel, amplitudeAtZeroIntensityLevel);
                generatePointsWithSomeAmplitude(points, currentAmplitude, intensityLevel);
            }
        }
        return points;
    }

    private Collection<DevicePointElement> generatePointsWithSomeAmplitude(Collection<DevicePointElement> points, double amplitude, BaseIntensityLevel intensityLevel) {
        for (Frequency frequency : Frequency.values()) {
            if (!frequency.equals(Frequency.NULL_VALUE)) {
                DevicePointElement pointDto = new DevicePointElement();
                pointDto.setIntensityLevel(intensityLevel.getValue());
                pointDto.setFrequency(frequency.getValue());
                pointDto.setSoundValue(amplitude);
                points.add(pointDto);
            }
        }
        return points;
    }

    public Device generateBasePoints(Device device) {
        List<DevicePointElement> zeroIntensityLevelPoints = getZeroDevicePoints(device);

        for (DevicePointElement item : zeroIntensityLevelPoints) {
            generatePointForBaseIntensityLevelRange(item);
        }
        return device;
    }

    private void generatePointForBaseIntensityLevelRange(DevicePointElement zeroPoint) {
        for (BaseIntensityLevel intensityLevel : BaseIntensityLevel.values()) {
            if (!intensityLevel.equals(BaseIntensityLevel.ZERO_INTENSITY_VALUE)) {
                DevicePointElement pointDto = generatePoint(intensityLevel.getValue(), zeroPoint);
                devicePointService.save(pointDto);
            }
        }
    }

    private DevicePointElement generatePoint(int intensityLevel, DevicePointElement deviceZero) {
        DevicePointElement pointDto = new DevicePointElement();
        pointDto.setDeviceId(deviceZero.getDeviceId());
        pointDto.setFrequency(deviceZero.getFrequency());
        pointDto.setIntensityLevel(intensityLevel);

        Double soundValue = SoundUtils.calculateSoundVolume(intensityLevel, deviceZero);
        pointDto.setSoundValue(soundValue);

        return pointDto;
    }

    private List<DevicePointElement> getZeroDevicePoints(Device device) {
        return devicePointService.getZeroIntensityLevelDevicePoints(device.getId());
    }
}
