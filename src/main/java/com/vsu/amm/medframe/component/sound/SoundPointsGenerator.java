package com.vsu.amm.medframe.component.sound;

import com.vsu.amm.medframe.model.dto.DevicePointResponse;
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

    public Collection<DevicePointResponse> generatePoints(DevicePointResponse startPoint) {
        Collection<DevicePointResponse> points = new ArrayList<DevicePointResponse>();

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

    private Collection<DevicePointResponse> generatePointsWithSomeAmplitude(Collection<DevicePointResponse> points, double amplitude, BaseIntensityLevel intensityLevel) {
        for (Frequency frequency : Frequency.values()) {
            if (!frequency.equals(Frequency.NULL_VALUE)) {
                DevicePointResponse pointDto = new DevicePointResponse();
                pointDto.setIntensityLevel(intensityLevel.getValue());
                pointDto.setFrequency(frequency.getValue());
                pointDto.setSoundValue(amplitude);
                points.add(pointDto);
            }
        }
        return points;
    }

    public Device generateBasePoints(Device device) {
        List<DevicePointResponse> zeroIntensityLevelPoints = getZeroDevicePoints(device);

        for (DevicePointResponse item : zeroIntensityLevelPoints) {
            generatePointForBaseIntensityLevelRange(item);
        }
        return device;
    }

    private void generatePointForBaseIntensityLevelRange(DevicePointResponse zeroPoint) {
        for (BaseIntensityLevel intensityLevel : BaseIntensityLevel.values()) {
            if (!intensityLevel.equals(BaseIntensityLevel.ZERO_INTENSITY_VALUE)) {
                DevicePointResponse pointDto = generatePoint(intensityLevel.getValue(), zeroPoint);
                devicePointService.save(pointDto);
            }
        }
    }

    private DevicePointResponse generatePoint(int intensityLevel, DevicePointResponse deviceZero) {
        DevicePointResponse pointDto = new DevicePointResponse();
        pointDto.setDeviceId(deviceZero.getDeviceId());
        pointDto.setFrequency(deviceZero.getFrequency());
        pointDto.setIntensityLevel(intensityLevel);

        Double soundValue = SoundUtils.calculateSoundVolume(intensityLevel, deviceZero);
        pointDto.setSoundValue(soundValue);

        return pointDto;
    }

    private List<DevicePointResponse> getZeroDevicePoints(Device device) {
        return devicePointService.getZeroIntensityLevelDevicePoints(device.getId());
    }
}
