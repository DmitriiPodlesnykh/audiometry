package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.component.mapper.DeviceMapper;
import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.repository.DeviceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    private static final Logger log = Logger.getLogger(DeviceService.class);

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceMapper mapper;

    public void save(DeviceDto dto) {
        Device device = mapper.mapToEntity(dto);
        deviceRepository.saveAndFlush(device);
    }
}
