package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.dto.DevicePointResponse;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface DevicePointMapper {

    DevicePointMapper INSTANCE = Mappers.getMapper( DevicePointMapper.class );

    CreateDevicePointRequest toCreateDevicePointRequest(DevicePoint entity);

    @InheritInverseConfiguration
    DevicePoint fromCreateDevicePointRequest(CreateDevicePointRequest dto);

    @Mapping(target = "deviceId", source = "device.id")
    DevicePointElement toDevicePointElement(DevicePoint entity);

    @InheritInverseConfiguration
    DevicePoint fromDevicePointElement(DevicePointElement dto);

    DevicePointResponse toDevicePointResponse(DevicePoint entity);

    @InheritInverseConfiguration
    DevicePoint fromDevicePointResponse(DevicePointResponse dto);

    Set<DevicePoint> createDevicePointRequestPointsToDevicePoints(Set<CreateDevicePointRequest> dtoSet);
}
