package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.model.dto.DevicePointElement;

import java.util.List;

public interface DevicePointService {

    DevicePointElement save(DevicePointElement pointDto);

    DevicePointElement getOne(Long id);

    List<DevicePointElement> getDevicePoints(Long deviceId);

    List<DevicePointElement> getZeroIntensityLevelDevicePoints(Long deviceId);
}
