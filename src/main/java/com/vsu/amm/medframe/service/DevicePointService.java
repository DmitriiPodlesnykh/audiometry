package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.model.dto.DevicePointResponse;

import java.util.List;

public interface DevicePointService {

    DevicePointResponse save(DevicePointResponse pointDto);

    DevicePointResponse getOne(Long id);

    List<DevicePointResponse> getDevicePoints(Long deviceId);

    List<DevicePointResponse> getZeroIntensityLevelDevicePoints(Long deviceId);
}
