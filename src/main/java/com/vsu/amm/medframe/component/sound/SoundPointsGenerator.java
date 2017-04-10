package com.vsu.amm.medframe.component.sound;

import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.entity.DevicePoint;
import com.vsu.amm.medframe.enums.Frequency;
import com.vsu.amm.medframe.service.DevicePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class SoundPointsGenerator {

    @Autowired
    DevicePointService devicePointService;

    public Device generateForDevice(Device device) {
        List<DevicePointDto> zeroIntensityLevelPoints = getZeroDevicePoints(device);

        for(DevicePointDto item : zeroIntensityLevelPoints) {
            for(int i=0; i < Frequency.values().length; i++) {
                //DevicePointDto pointDto = generatePoint()
            }
        }

        return device;
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