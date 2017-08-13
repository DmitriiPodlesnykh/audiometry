package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface DevicePointMapper {

    DevicePointMapper INSTANCE = Mappers.getMapper( DevicePointMapper.class );

    DevicePoint toEntity(CreateDevicePointRequest dto);

    @Mappings({
            @Mapping(target = "device.id", source = "deviceId")
    })
    DevicePoint toEntity(DevicePointElement dto);

    CreateDevicePointRequest toCreateDevicePointRequest(DevicePoint entity);

    @Mappings({
            @Mapping(target = "deviceId", source = "device.id")
    })
    DevicePointElement toDevicePointElement(DevicePoint entity);

    Set<DevicePoint> createDevicePointRequestPointsToDevicePoints(Set<CreateDevicePointRequest> dtoSet);
}
