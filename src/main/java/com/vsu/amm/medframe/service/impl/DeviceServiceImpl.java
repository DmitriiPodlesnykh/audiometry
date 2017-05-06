package com.vsu.amm.medframe.service.impl;

import com.vsu.amm.medframe.component.mapper.DeviceMapper;
import com.vsu.amm.medframe.component.sound.SoundPointsGenerator;
import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.entity.DevicePoint;
import com.vsu.amm.medframe.repository.DevicePointRepository;
import com.vsu.amm.medframe.repository.DeviceRepository;
import com.vsu.amm.medframe.service.DeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService{

    private static final Logger log = Logger.getLogger(DeviceServiceImpl.class);

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DevicePointRepository devicePointRepository;

    @Autowired
    private DeviceMapper mapper;

    @Autowired
    private SoundPointsGenerator soundPointsGenerator;

    public DeviceDto getWithGeneratedPoints(DevicePointDto pointDto) {
        log.info("pointDto.getSoundValue()" + pointDto.getSoundValue());
        return soundPointsGenerator.generateBasePoints(pointDto);
    }

    public DeviceDto createNew() {
        Device device = new Device();
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }

    public DeviceDto save(DeviceDto dto) {
        Device device = mapper.mapToEntity(dto);
        List<DevicePoint> points = device.getDevicePoints();
        device = deviceRepository.saveAndFlush(device);
        for(int i=0; i<points.size();i++) {
            points.set(i, devicePointRepository.saveAndFlush(points.get(i)));
        }
        return mapper.mapToDto(device);
    }

    public DeviceDto getOne(Long id) {
        Device device = deviceRepository.findDeviceWithPointsByIdQuery(id);
        log.info("device = " + device.toString());
        return mapper.mapToDto(device);
    }

    public List<DeviceDto> getAll(){
        List<Device> devices = deviceRepository.findAll();
        if(devices == null || devices.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DeviceDto> deviceDos = new ArrayList<DeviceDto>();
        for(Device device : devices) {
            DeviceDto deviceDto = mapper.mapToDto(device);
            deviceDos.add(deviceDto);
        }
        return deviceDos;
    }

    public DeviceDto updateDevice(DeviceDto deviceDto) {
        Device device = deviceRepository.getOne(deviceDto.getId());
        if(!device.getHeadphoneName().equals(deviceDto.getHeadphoneName())) {
            device.setHeadphoneName(deviceDto.getHeadphoneName());
        }
        if(!device.getSoundCardName().equals(deviceDto.getSoundCardName())) {
            device.setSoundCardName(deviceDto.getSoundCardName());
        }
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }

    public DeviceDto generateDevicePoints(Long deviceId) {
        Device device = deviceRepository.findOne(deviceId);
        device = soundPointsGenerator.generateBasePoints(device);
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }
}
