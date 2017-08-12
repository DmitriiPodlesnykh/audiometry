package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DevicePointMapper {
    //@Mapping(source = "frequency", target = "Frequency.parse()")
    //DevicePoint mapToEntity(CreateDevicePointRequest dto);

    CreateDevicePointRequest mapToCreateDevicePointRequest(DevicePoint entity);

    //DevicePointElement mapToDevicePointElement(DevicePoint entity);
}
