package com.vsu.amm.audiometry.service.impl;

import com.vsu.amm.audiometry.component.sound.SoundPointsGenerator;
import com.vsu.amm.audiometry.mapper.DeviceMapper;
import com.vsu.amm.audiometry.model.dto.CreateDeviceRequest;
import com.vsu.amm.audiometry.model.dto.DeviceResponse;
import com.vsu.amm.audiometry.model.entity.Device;
import com.vsu.amm.audiometry.repository.DeviceRepository;
import com.vsu.amm.audiometry.service.DevicePointService;
import com.vsu.amm.audiometry.service.DeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    private static final Logger LOGGER = Logger.getLogger(DeviceServiceImpl.class);

    private final DeviceRepository deviceRepository;
    private final SoundPointsGenerator soundPointsGenerator;
    private final DevicePointService devicePointService;

    private static final int ZERO_INTENSITY_1000HZ_POINT_NUMBER = 0;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository,
                             SoundPointsGenerator soundPointsGenerator,
                             DevicePointService devicePointService) {
        this.deviceRepository = deviceRepository;
        this.soundPointsGenerator = soundPointsGenerator;
        this.devicePointService = devicePointService;
    }

    @Override
    public DeviceResponse generatedPointsAndSave(DeviceResponse deviceResponse) {
        //TODO fix it
//        deviceResponse.setPoints(
//                (List<DevicePointElement>) soundPointsGenerator.generatePoints(
//                        deviceResponse.setPoints().get(ZERO_INTENSITY_1000HZ_POINT_NUMBER)));
//        log.info(deviceResponse.setPoints().toString());

        // deviceResponse = save(deviceResponse);
        return deviceResponse;
    }

    @Override
    public DeviceResponse create() {
        Device device = new Device();
        device = deviceRepository.saveAndFlush(device);
        return DeviceMapper.INSTANCE.toDeviceResponse(device);
    }

    @Override
    public DeviceResponse save(CreateDeviceRequest dto) {
        Device device = DeviceMapper.INSTANCE.toEntity(dto);
        device = deviceRepository.saveAndFlush(device);
        device.setDevicePoints(devicePointService.update(device));

        LOGGER.info("device = " + device.toString());
        LOGGER.info("DeviceResponse = " + DeviceMapper.INSTANCE.toDeviceResponse(device));
        return DeviceMapper.INSTANCE.toDeviceResponse(device);
    }

    @Override
    public DeviceResponse getOne(Long id) {
        Device device = deviceRepository.findDeviceWithPointsByIdQuery(id);
        return DeviceMapper.INSTANCE.toDeviceResponse(device);
    }

    @Override
    public List<DeviceResponse> getAll() {
        List<Device> devices = deviceRepository.findAll();
        if (devices == null || devices.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DeviceResponse> deviceDos = new ArrayList<DeviceResponse>();
        for (Device device : devices) {
            DeviceResponse deviceResponse = DeviceMapper.INSTANCE.toDeviceResponse(device);
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
        return DeviceMapper.INSTANCE.toDeviceResponse(device);
    }

    @Override
    public DeviceResponse generateDevicePoints(Long deviceId) {
        Device device = deviceRepository.findOne(deviceId);
        device = soundPointsGenerator.generateBasePoints(device);
        device = deviceRepository.saveAndFlush(device);
        return DeviceMapper.INSTANCE.toDeviceResponse(device);
    }
}
