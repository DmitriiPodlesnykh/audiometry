package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateDeviceRequest;
import com.vsu.amm.audiometry.model.dto.DeviceResponse;
import com.vsu.amm.audiometry.model.entity.Device;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {DevicePointMapper.class}
)
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    @Mapping(source = "devicePoints", target = "points")
    DeviceResponse toDeviceResponse(Device entity);

    @InheritInverseConfiguration
    Device fromDeviceResponse(DeviceResponse dto);

    @Mapping(source = "points", target = "devicePoints")
    Device toEntity(CreateDeviceRequest dto);
}
