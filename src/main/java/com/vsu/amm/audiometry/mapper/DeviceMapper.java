package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateDeviceRequest;
import com.vsu.amm.audiometry.model.dto.DeviceResponse;
import com.vsu.amm.audiometry.model.entity.Device;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    Device mapToEntity(CreateDeviceRequest dto);

    Device mapToEntity(DeviceResponse dto);

    DeviceResponse mapToDeviceResponse(Device entity);

    CreateDeviceRequest mapToCreateDeviceRequest(Device entity);
}
