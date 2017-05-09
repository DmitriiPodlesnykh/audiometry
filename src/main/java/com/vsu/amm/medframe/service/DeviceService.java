package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.dto.DevicePointDto;

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
