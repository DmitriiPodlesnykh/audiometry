package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DevicePointMapper {
    //@Mapping(source = "frequency", target = "Frequency.parse()")
    //DevicePoint mapToEntity(CreateDevicePointRequest dto);

    @Mapping(source = "frequency.value", target = "frequency")
    CreateDevicePointRequest mapToCreateDevicePointRequest(DevicePoint entity);

    //DevicePointElement mapToDevicePointElement(DevicePoint entity);
}
