package com.vsu.amm.medframe.component.sound;

import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.entity.DevicePoint;
import com.vsu.amm.medframe.enums.BaseIntensityLevel;
import com.vsu.amm.medframe.enums.Frequency;
import com.vsu.amm.medframe.service.DevicePointService;
import com.vsu.amm.medframe.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SoundPointsGenerator {

    @Autowired
    private DevicePointService devicePointService;

    @Autowired
    private DeviceService deviceService;

    public DeviceDto generateBasePoints(DevicePointDto devicePoint) {
        DeviceDto device = deviceService.createNew();

        double amplitudeAtZeroIntensityLevel =  devicePoint.getSoundValue();

        Collection<DevicePointDto> devicePoints= new ArrayList<DevicePointDto>();

        for(BaseIntensityLevel intensityLevel : BaseIntensityLevel.values()) {
            if(intensityLevel.equals(BaseIntensityLevel.ZERO_INTENSITY_VALUE)) {
                generatePointsWithSomeAmplitude(devicePoints, amplitudeAtZeroIntensityLevel, intensityLevel, device.getId());
            } else {
                double currentAmplitude = createAmplitude(intensityLevel, amplitudeAtZeroIntensityLevel);
                generatePointsWithSomeAmplitude(devicePoints, currentAmplitude, intensityLevel, device.getId());
            }
        }
        device.setPointList((List<DevicePointDto>) devicePoint);
        device = deviceService.save(device);
        return device;
    }


    private double createAmplitude(BaseIntensityLevel intensityLevel, double amplitudeAtZeroIntensityLevel) {
        return 0;
    }

    private Collection<DevicePointDto> generatePointsWithSomeAmplitude(Collection<DevicePointDto> points, double amplitude, BaseIntensityLevel intensityLevel, Long deviceId) {
        for(Frequency frequency : Frequency.values()) {
            DevicePointDto pointDto = new DevicePointDto();
            pointDto.setIntensityLevel(intensityLevel.getValue());
            pointDto.setDeviceId(deviceId);
            pointDto.setFrequency(frequency.getValue());
            pointDto.setSoundValue(amplitude);
            points.add(pointDto);
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

    public Device generateForSelectedFrequencies(Collection<DevicePoint> zeroDbPoints, Device device) {
        for (DevicePoint point : zeroDbPoints) {
            if (validatePointDevice(point.getDevice().getId(), device.getId())) {

            }
        }
        return device;
    }


    private boolean validatePointDevice(Long deicePointDeviceId, Long deviceId) {
        return deicePointDeviceId.equals(deviceId);
    }

}
