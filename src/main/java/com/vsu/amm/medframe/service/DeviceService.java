package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.model.dto.DeviceDto;

import java.util.List;

public interface DeviceService {

    DeviceDto save(DeviceDto dto);

    DeviceDto createNew();

    DeviceDto getOne(Long id);

    DeviceDto updateDevice(DeviceDto deviceDto);

    List<DeviceDto> getAll();

    DeviceDto generateDevicePoints(Long deviceId);

    DeviceDto generatedPointsAndSave(DeviceDto deviceDto);

}
