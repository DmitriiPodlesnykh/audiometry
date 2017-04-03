package com.vsu.amm.medframe.component.sound;

import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.entity.DevicePoint;
import com.vsu.amm.medframe.service.DevicePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class SoundPointsGenerator {

    @Autowired
    DevicePointService devicePointService;

    public Device generateForDevice(Device device) {

        if(device.getDevicePoints() != null && !device.getDevicePoints().isEmpty()) {
            for (DevicePoint point : device.getDevicePoints()) {

            }
        }

        return device;
    }

}
