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
public class DeviceServiceImpl implements DeviceService {

    private static final Logger log = Logger.getLogger(DeviceServiceImpl.class);

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DevicePointRepository devicePointRepository;

    @Autowired
    private DeviceMapper mapper;

    @Autowired
    private SoundPointsGenerator soundPointsGenerator;

    private static final int ZERO_INTENSITY_1000HZ_POINT_NUMBER = 0;

    @Override
    public DeviceDto generatedPointsAndSave(DeviceDto deviceDto) {
        deviceDto.setPointList(
                (List<DevicePointDto>) soundPointsGenerator.generatePoints(
                        deviceDto.getPointList().get(ZERO_INTENSITY_1000HZ_POINT_NUMBER)));
        log.info(deviceDto.getPointList().toString());
        deviceDto = save(deviceDto);
        return deviceDto;
    }

    @Override
    public DeviceDto createNew() {
        Device device = new Device();
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }

    @Override
    public DeviceDto save(DeviceDto dto) {
        Device device = mapper.mapToEntity(dto);
        if (device.getDevicePoints() != null && !device.getDevicePoints().isEmpty()) {
            // TODO to fix it on bulk case
            List<DevicePoint> points = device.getDevicePoints();
            device.setDevicePoints(Collections.EMPTY_LIST);
            device = deviceRepository.saveAndFlush(device);
            for (DevicePoint point : points) {
                log.info("point before add device = " + point.toString());
                point.setDevice(device);
                point = devicePointRepository.saveAndFlush(point);
                log.info("point = " + point.toString());
            }
            device.setDevicePoints(points);
            device = deviceRepository.saveAndFlush(device);
        } else {
            device = deviceRepository.saveAndFlush(device);
        }
        return mapper.mapToDto(device);
    }

    @Override
    public DeviceDto getOne(Long id) {
        Device device = deviceRepository.findDeviceWithPointsByIdQuery(id);
        return mapper.mapToDto(device);
    }

    @Override
    public List<DeviceDto> getAll() {
        List<Device> devices = deviceRepository.findAll();
        if (devices == null || devices.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DeviceDto> deviceDos = new ArrayList<DeviceDto>();
        for (Device device : devices) {
            DeviceDto deviceDto = mapper.mapToDto(device);
            deviceDos.add(deviceDto);
        }
        return deviceDos;
    }

    @Override
    public DeviceDto updateDevice(DeviceDto deviceDto) {
        Device device = deviceRepository.getOne(deviceDto.getId());
        if (!device.getHeadphoneName().equals(deviceDto.getHeadphoneName())) {
            device.setHeadphoneName(deviceDto.getHeadphoneName());
        }
        if (!device.getSoundCardName().equals(deviceDto.getSoundCardName())) {
            device.setSoundCardName(deviceDto.getSoundCardName());
        }
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }

    @Override
    public DeviceDto generateDevicePoints(Long deviceId) {
        Device device = deviceRepository.findOne(deviceId);
        device = soundPointsGenerator.generateBasePoints(device);
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }
}
