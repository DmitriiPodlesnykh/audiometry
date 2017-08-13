package com.vsu.amm.audiometry.component.sound;

import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.entity.Device;
import com.vsu.amm.audiometry.service.DevicePointService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SoundPointsGenerator {

    private static final Logger LOGGER = Logger.getLogger(SoundPointsGenerator.class);

    @Autowired
    private DevicePointService devicePointService;

    private Set<Integer> availableFrequencies = new TreeSet<Integer>();

    public Collection<DevicePointElement> generatePoints(DevicePointElement startPoint) {
        Collection<DevicePointElement> points = new ArrayList<DevicePointElement>();

        double amplitudeAtZeroIntensityLevel = startPoint.getVolumeValue();
//todo fix it
//        for (BaseIntensityLevel intensityLevel : BaseIntensityLevel.values()) {
//            if (intensityLevel.equals(BaseIntensityLevel.ZERO_INTENSITY_VALUE)) {
//                generatePointsWithSomeAmplitude(points, amplitudeAtZeroIntensityLevel, intensityLevel);
//            } else {
//                double currentAmplitude = SoundUtils.createAmplitudeValue(intensityLevel, amplitudeAtZeroIntensityLevel);
//                generatePointsWithSomeAmplitude(points, currentAmplitude, intensityLevel);
//            }
//        }
        return points;
    }

    private Collection<DevicePointElement> generatePointsWithSomeAmplitude(Collection<DevicePointElement> points, double amplitude, Integer intensityLevel) {
        for(Integer frequency : availableFrequencies) {
                DevicePointElement pointDto = new DevicePointElement();
                pointDto.setIntensityLevel(intensityLevel);
                pointDto.setFrequency(frequency);
                pointDto.setVolumeValue(amplitude);
                points.add(pointDto);
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
// todo fix it
// for (BaseIntensityLevel intensityLevel : BaseIntensityLevel.values()) {
//            if (!intensityLevel.equals(BaseIntensityLevel.ZERO_INTENSITY_VALUE)) {
//                DevicePointElement pointDto = generatePoint(intensityLevel.getValue(), zeroPoint);
//                devicePointService.save(pointDto);
//            }
//        }
    }

    private DevicePointElement generatePoint(int intensityLevel, DevicePointElement deviceZero) {
        DevicePointElement pointDto = new DevicePointElement();
        pointDto.setDeviceId(deviceZero.getDeviceId());
        pointDto.setFrequency(deviceZero.getFrequency());
        pointDto.setIntensityLevel(intensityLevel);

        Double soundValue = SoundUtils.calculateSoundVolume(intensityLevel, deviceZero);
        pointDto.setVolumeValue(soundValue);

        return pointDto;
    }

    private List<DevicePointElement> getZeroDevicePoints(Device device) {
        return devicePointService.getZeroIntensityLevelDevicePoints(device.getId());
    }
}
