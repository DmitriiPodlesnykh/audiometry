package com.vsu.amm.audiometry.service.impl;

import com.vsu.amm.audiometry.mapper.DevicePointMapper;
import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import com.vsu.amm.audiometry.repository.DevicePointRepository;
import com.vsu.amm.audiometry.service.DevicePointService;
import org.apache.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DevicePointServiceImpl implements DevicePointService{

    private static final Logger LOGGER = Logger.getLogger(DevicePointServiceImpl.class);

    @Autowired
    DevicePointRepository devicePointRepository;

    @Override
    public DevicePointElement save(CreateDevicePointRequest pointRequest) {
        DevicePointElement pointElement = new DevicePointElement();
        pointElement.setVolumeValue(pointRequest.getVolumeValue());
        pointElement.setIntensityLevel(pointRequest.getIntensityLevel());
        pointElement.setFrequency(pointRequest.getFrequency());
        pointElement.setDeviceId(999L);
        pointElement.setId(9999L);
        return pointElement;
    }

    @Override
    public DevicePointElement update(DevicePointElement pointDto) {
        DevicePoint point = DevicePointMapper.INSTANCE.fromDevicePointElement(pointDto);
        point = devicePointRepository.saveAndFlush(point);
        return DevicePointMapper.INSTANCE.toDevicePointElement(point);
    }

    @Override
    public DevicePointElement getOne(Long id) {
        DevicePoint point = devicePointRepository.getOne(id);
        return DevicePointMapper.INSTANCE.toDevicePointElement(point);
    }

    @Override
    public List<DevicePointElement> getDevicePoints(Long deviceId) {
        List<DevicePoint> points = (List<DevicePoint>) devicePointRepository.findByDeviceId(deviceId);
        if (points == null || points.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DevicePointElement> pointDtos = new ArrayList<DevicePointElement>();
        for (DevicePoint point : points) {
            DevicePointElement pointDto = DevicePointMapper.INSTANCE.toDevicePointElement(point);
            pointDtos.add(pointDto);
        }
        LOGGER.info(pointDtos.toString());
        return pointDtos;
    }

    @Override
    public List<DevicePointElement> getZeroIntensityLevelDevicePoints(Long deviceId) {
        List<DevicePoint> devicePoints = (List<DevicePoint>) devicePointRepository.getZeroIntensityLevelDevicePointsByDeviceId(deviceId);
        if (devicePoints == null || devicePoints.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DevicePointElement> pointDtos = new ArrayList<DevicePointElement>();
        for (DevicePoint point : devicePoints) {
            DevicePointElement pointDto = DevicePointMapper.INSTANCE.toDevicePointElement(point);
            pointDtos.add(pointDto);
        }
        LOGGER.info(pointDtos.toString());
        return pointDtos;
    }
}
