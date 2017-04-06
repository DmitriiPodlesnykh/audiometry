package com.vsu.amm.medframe.component.sound;

import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.entity.DevicePoint;
import com.vsu.amm.medframe.service.DevicePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class SoundPointsGenerator {

    @Autowired
    DevicePointService devicePointService;

    public Device generateForDevice(Device device) {

        List<DevicePointDto> zeroIntensityLevelPoints = devicePointService.getDevicePoints(device.getId());
        if(zeroIntensityLevelPoints == null && zeroIntensityLevelPoints.isEmpty()) {
            throw new RuntimeException("don't have 0db points");
        }

        if (device.getDevicePoints() != null && !device.getDevicePoints().isEmpty()) {
            for (DevicePoint point : device.getDevicePoints()) {

            }
        }

        return device;
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
