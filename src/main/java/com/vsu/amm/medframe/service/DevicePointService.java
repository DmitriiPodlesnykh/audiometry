package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.model.dto.DevicePointDto;

import java.util.List;

public interface DevicePointService {

    DevicePointDto save(DevicePointDto pointDto);

    DevicePointDto getOne(Long id);

    List<DevicePointDto> getDevicePoints(Long deviceId);

    List<DevicePointDto> getZeroIntensityLevelDevicePoints(Long deviceId);
}
