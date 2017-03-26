package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.component.mapper.DevicePointMapper;
import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.DevicePoint;
import com.vsu.amm.medframe.repository.DevicePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevicePointService {

    @Autowired
    DevicePointRepository devicePointRepository;

    @Autowired
    DevicePointMapper mapper;

    public DevicePointDto save(DevicePointDto pointDto) {
        DevicePoint point = mapper.mapToEntity(pointDto);
        point = devicePointRepository.saveAndFlush(point);
        return mapper.mapToDto(point);
    }
}
