package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.component.mapper.DeviceMapper;
import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.repository.DeviceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private static final Logger log = Logger.getLogger(DeviceService.class);

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceMapper mapper;

    public DeviceDto save(DeviceDto dto) {
        Device device = mapper.mapToEntity(dto);
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }

    public DeviceDto getOne(Long id) {
        Device device = deviceRepository.findOne(id);
        return mapper.mapToDto(device);
    }

    public List<DeviceDto> getAll(){
        return null;
    }
}
