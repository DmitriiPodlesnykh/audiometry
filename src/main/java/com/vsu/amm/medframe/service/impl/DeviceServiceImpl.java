package com.vsu.amm.medframe.service.impl;

import com.vsu.amm.medframe.component.mapper.impl.DeviceMapper;
import com.vsu.amm.medframe.component.sound.SoundPointsGenerator;
import com.vsu.amm.medframe.model.dto.CreateDeviceRequest;
import com.vsu.amm.medframe.model.dto.DeviceResponse;
import com.vsu.amm.medframe.model.dto.DevicePointResponse;
import com.vsu.amm.medframe.model.entity.Device;
import com.vsu.amm.medframe.model.entity.DevicePoint;
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
    public DeviceResponse generatedPointsAndSave(DeviceResponse deviceResponse) {
        //TODO fix it
//        deviceResponse.setPoints(
//                (List<DevicePointResponse>) soundPointsGenerator.generatePoints(
//                        deviceResponse.setPoints().get(ZERO_INTENSITY_1000HZ_POINT_NUMBER)));
//        log.info(deviceResponse.setPoints().toString());

        // deviceResponse = save(deviceResponse);
        return deviceResponse;
    }

    @Override
    public DeviceResponse createNew() {
        Device device = new Device();
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }

    @Override
    public DeviceResponse save(CreateDeviceRequest dto) {
        Device device = new Device();//TODO fix it
        // mapper.mapToEntity(dto);
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
    public DeviceResponse getOne(Long id) {
        Device device = deviceRepository.findDeviceWithPointsByIdQuery(id);
        return mapper.mapToDto(device);
    }

    @Override
    public List<DeviceResponse> getAll() {
        List<Device> devices = deviceRepository.findAll();
        if (devices == null || devices.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DeviceResponse> deviceDos = new ArrayList<DeviceResponse>();
        for (Device device : devices) {
            DeviceResponse deviceResponse = mapper.mapToDto(device);
            deviceDos.add(deviceResponse);
        }
        return deviceDos;
    }

    @Override
    public DeviceResponse updateDevice(DeviceResponse deviceResponse) {
        Device device = deviceRepository.getOne(deviceResponse.getId());
        if (!device.getHeadphoneName().equals(deviceResponse.getHeadphoneName())) {
            device.setHeadphoneName(deviceResponse.getHeadphoneName());
        }
        if (!device.getSoundCardName().equals(deviceResponse.getSoundCardName())) {
            device.setSoundCardName(deviceResponse.getSoundCardName());
        }
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }

    @Override
    public DeviceResponse generateDevicePoints(Long deviceId) {
        Device device = deviceRepository.findOne(deviceId);
        device = soundPointsGenerator.generateBasePoints(device);
        device = deviceRepository.saveAndFlush(device);
        return mapper.mapToDto(device);
    }
}
