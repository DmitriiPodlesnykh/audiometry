package com.vsu.amm.audiometry.service;

import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;

import java.util.List;

public interface DevicePointService {

    DevicePointElement save(CreateDevicePointRequest pointDto);

    DevicePointElement update(DevicePointElement pointElement);

    DevicePointElement getOne(Long id);

    List<DevicePointElement> getDevicePoints(Long deviceId);

    List<DevicePointElement> getZeroIntensityLevelDevicePoints(Long deviceId);
}
