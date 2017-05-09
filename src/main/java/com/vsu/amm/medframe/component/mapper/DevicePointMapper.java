package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.DevicePoint;
import com.vsu.amm.medframe.enums.Frequency;
import com.vsu.amm.medframe.repository.DeviceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DevicePointMapper implements Mapper<DevicePoint, DevicePointDto> {

    private static final Logger LOGGER = Logger.getLogger(DevicePointMapper.class);

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public DevicePoint mapToEntity(DevicePointDto pointDto) {
        DevicePoint point = new DevicePoint();
        if (pointDto.getDeviceId() != null) {
            point.setDevice(deviceRepository.getOne(pointDto.getDeviceId()));
        }
        point.setFrequency(Frequency.parse(pointDto.getFrequency()));
        point.setIntensityLevel(pointDto.getIntensityLevel());
        point.setVolumeValue(new BigDecimal(pointDto.getSoundValue()));
        if (pointDto.getId() != null) {
            point.setId(pointDto.getId());
        }
        return point;
    }

    @Override
    public DevicePointDto mapToDto(DevicePoint devicePoint) {
        DevicePointDto dto = new DevicePointDto();

        if (devicePoint.getId() != null) {
            dto.setId(devicePoint.getId());
        }
        if (devicePoint.getDevice() != null) {
            dto.setDeviceId(devicePoint.getDevice().getId());
        }
        dto.setFrequency(devicePoint.getFrequency().getValue());
        if (devicePoint.getIntensityLevel() != null) {
            dto.setIntensityLevel(devicePoint.getIntensityLevel());
        }
        if (devicePoint.getVolumeValue() != null) {
            dto.setSoundValue(devicePoint.getVolumeValue().doubleValue());
        }
        return dto;
    }
}
