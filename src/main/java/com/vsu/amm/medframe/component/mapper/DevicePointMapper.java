package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.DevicePoint;
import com.vsu.amm.medframe.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DevicePointMapper implements Mapper<DevicePoint, DevicePointDto>{

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public DevicePoint mapToEntity(DevicePointDto pointDto) {
        DevicePoint point = new DevicePoint();
        point.setDevice(deviceRepository.getOne(pointDto.getId()));
        point.setFrequency(pointDto.getFrequency());
        point.setIntensityLevel(pointDto.getIntensityLevel());
        point.setVolumeValue(new BigDecimal(pointDto.getIntensityLevel()));
        if(pointDto.getId() != null){
            point.setId(pointDto.getId());
        }
        return point;
    }

    @Override
    public DevicePointDto mapToDto(DevicePoint devicePoint) {
        DevicePointDto dto = new DevicePointDto();

        dto.setId(devicePoint.getId());
        dto.setDeviceId(devicePoint.getDevice().getId());
        dto.setFrequency(devicePoint.getFrequency());
        dto.setIntensityLevel(devicePoint.getIntensityLevel());
        dto.setSoundValue(devicePoint.getVolumeValue().doubleValue());

        return dto;
    }
}
