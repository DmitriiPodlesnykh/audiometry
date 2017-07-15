package com.vsu.amm.medframe.service.impl;

import com.vsu.amm.medframe.component.mapper.impl.DevicePointMapper;
import com.vsu.amm.medframe.model.dto.DevicePointResponse;
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
    public DevicePointResponse save(DevicePointResponse pointDto) {
        DevicePoint point = mapper.mapToEntity(pointDto);
        point = devicePointRepository.saveAndFlush(point);
        return mapper.mapToDto(point);
    }

    @Override
    public DevicePointResponse getOne(Long id) {
        DevicePoint point = devicePointRepository.getOne(id);
        return mapper.mapToDto(point);
    }

    @Override
    public List<DevicePointResponse> getDevicePoints(Long deviceId) {
        List<DevicePoint> points = (List<DevicePoint>) devicePointRepository.findByDeviceId(deviceId);
        if (points == null || points.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DevicePointResponse> pointDtos = new ArrayList<DevicePointResponse>();
        for (DevicePoint point : points) {
            DevicePointResponse pointDto = mapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        LOGGER.info(pointDtos.toString());
        return pointDtos;
    }

    @Override
    public List<DevicePointResponse> getZeroIntensityLevelDevicePoints(Long deviceId) {
        List<DevicePoint> devicePoints = (List<DevicePoint>) devicePointRepository.getZeroIntensityLevelDevicePointsByDeviceId(deviceId);
        if (devicePoints == null || devicePoints.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DevicePointResponse> pointDtos = new ArrayList<DevicePointResponse>();
        for (DevicePoint point : devicePoints) {
            DevicePointResponse pointDto = mapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        LOGGER.info(pointDtos.toString());
        return pointDtos;
    }


}
