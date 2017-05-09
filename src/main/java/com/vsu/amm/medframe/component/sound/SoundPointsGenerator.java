package com.vsu.amm.medframe.component.sound;

import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.enums.BaseIntensityLevel;
import com.vsu.amm.medframe.enums.Frequency;
import com.vsu.amm.medframe.service.impl.DevicePointServiceImpl;
import com.vsu.amm.medframe.service.impl.DeviceServiceImpl;
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
    private DevicePointServiceImpl devicePointService;

    @Autowired
    private DeviceServiceImpl deviceService;

    public Collection<DevicePointDto> generatePoints(DevicePointDto startPoint) {
        Collection<DevicePointDto> points = new ArrayList<DevicePointDto>();

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

    private Collection<DevicePointDto> generatePointsWithSomeAmplitude(Collection<DevicePointDto> points, double amplitude, BaseIntensityLevel intensityLevel) {
        for (Frequency frequency : Frequency.values()) {
            if (!frequency.equals(Frequency.NULL_VALUE)) {
                DevicePointDto pointDto = new DevicePointDto();
                pointDto.setIntensityLevel(intensityLevel.getValue());
                pointDto.setFrequency(frequency.getValue());
                pointDto.setSoundValue(amplitude);
                points.add(pointDto);
            }
        }
        return points;
    }

    public Device generateBasePoints(Device device) {
        List<DevicePointDto> zeroIntensityLevelPoints = getZeroDevicePoints(device);

        for (DevicePointDto item : zeroIntensityLevelPoints) {
            generatePointForBaseIntensityLevelRange(item);
        }
        return device;
    }

    private void generatePointForBaseIntensityLevelRange(DevicePointDto zeroPoint) {
        for (BaseIntensityLevel intensityLevel : BaseIntensityLevel.values()) {
            if (!intensityLevel.equals(BaseIntensityLevel.ZERO_INTENSITY_VALUE)) {
                DevicePointDto pointDto = generatePoint(intensityLevel.getValue(), zeroPoint);
                devicePointService.save(pointDto);
            }
        }
    }

    private DevicePointDto generatePoint(int intensityLevel, DevicePointDto deviceZero) {
        DevicePointDto pointDto = new DevicePointDto();
        pointDto.setDeviceId(deviceZero.getDeviceId());
        pointDto.setFrequency(deviceZero.getFrequency());
        pointDto.setIntensityLevel(intensityLevel);

        Double soundValue = SoundUtils.calculateSoundVolume(intensityLevel, deviceZero);
        pointDto.setSoundValue(soundValue);

        return pointDto;
    }

    private List<DevicePointDto> getZeroDevicePoints(Device device) {
        return devicePointService.getZeroIntensityLevelDevicePoints(device.getId());
    }
}
