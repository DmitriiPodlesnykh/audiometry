package com.vsu.amm.audiometry.service;

import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.entity.Device;
import com.vsu.amm.audiometry.model.entity.DevicePoint;

import java.util.List;
import java.util.Set;

public interface DevicePointService {

    Set<DevicePoint> update(Device device);

    DevicePointElement save(CreateDevicePointRequest pointDto);

    DevicePointElement update(DevicePointElement pointElement);

    DevicePointElement getOne(Long id);

    List<DevicePointElement> getDevicePoints(Long deviceId);

    List<DevicePointElement> getZeroIntensityLevelDevicePoints(Long deviceId);
}
