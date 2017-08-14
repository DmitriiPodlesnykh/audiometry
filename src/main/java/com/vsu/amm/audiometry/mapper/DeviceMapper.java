package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateDeviceRequest;
import com.vsu.amm.audiometry.model.dto.DeviceResponse;
import com.vsu.amm.audiometry.model.entity.Device;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    DeviceResponse toDeviceResponse(Device entity);

    @InheritInverseConfiguration
    Device fromDeviceResponse(DeviceResponse dto);

    CreateDeviceRequest mapToCreateDeviceRequest(Device entity);

    @InheritInverseConfiguration
    Device fromCreateDeviceRequest(CreateDeviceRequest dto);
}
