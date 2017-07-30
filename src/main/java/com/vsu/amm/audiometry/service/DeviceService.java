package com.vsu.amm.audiometry.service;

import com.vsu.amm.audiometry.model.dto.CreateDeviceRequest;
import com.vsu.amm.audiometry.model.dto.DeviceResponse;

import java.util.List;

public interface DeviceService {

    DeviceResponse save(CreateDeviceRequest dto);

    DeviceResponse createNew();

    DeviceResponse getOne(Long id);

    DeviceResponse updateDevice(DeviceResponse deviceResponse);

    List<DeviceResponse> getAll();

    DeviceResponse generateDevicePoints(Long deviceId);

    DeviceResponse generatedPointsAndSave(DeviceResponse deviceResponse);

}
