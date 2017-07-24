package com.vsu.amm.medframe.service.impl;

import com.vsu.amm.medframe.component.mapper.impl.DevicePointMapper;
import com.vsu.amm.medframe.model.dto.DevicePointElement;
import com.vsu.amm.medframe.model.entity.DevicePoint;
import com.vsu.amm.medframe.repository.DevicePointRepository;
import com.vsu.amm.medframe.service.DevicePointService;
import org.apache.log4j.Logger;
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

    @Autowired
    DevicePointMapper mapper;

    @Override
    public DevicePointElement save(DevicePointElement pointDto) {
        DevicePoint point = mapper.mapToEntity(pointDto);
        point = devicePointRepository.saveAndFlush(point);
        return mapper.mapToDto(point);
    }

    @Override
    public DevicePointElement getOne(Long id) {
        DevicePoint point = devicePointRepository.getOne(id);
        return mapper.mapToDto(point);
    }

    @Override
    public List<DevicePointElement> getDevicePoints(Long deviceId) {
        List<DevicePoint> points = (List<DevicePoint>) devicePointRepository.findByDeviceId(deviceId);
        if (points == null || points.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DevicePointElement> pointDtos = new ArrayList<DevicePointElement>();
        for (DevicePoint point : points) {
            DevicePointElement pointDto = mapper.mapToDto(point);
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
            DevicePointElement pointDto = mapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        LOGGER.info(pointDtos.toString());
        return pointDtos;
    }


}
