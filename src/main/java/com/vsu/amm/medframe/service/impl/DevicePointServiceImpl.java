package com.vsu.amm.medframe.service.impl;

import com.vsu.amm.medframe.component.mapper.DevicePointMapper;
import com.vsu.amm.medframe.dto.DevicePointDto;
import com.vsu.amm.medframe.entity.DevicePoint;
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

    private static final Logger log = Logger.getLogger(DevicePointServiceImpl.class);

    @Autowired
    DevicePointRepository devicePointRepository;

    @Autowired
    DevicePointMapper mapper;

    public DevicePointDto save(DevicePointDto pointDto) {
        DevicePoint point = mapper.mapToEntity(pointDto);
        point = devicePointRepository.saveAndFlush(point);
        return mapper.mapToDto(point);
    }

    public DevicePointDto getOne(Long id) {
        DevicePoint point = devicePointRepository.getOne(id);
        return mapper.mapToDto(point);
    }

    public List<DevicePointDto> getDevicePoints(Long deviceId) {
        List<DevicePoint> points = (List<DevicePoint>) devicePointRepository.findByDeviceId(deviceId);
        if (points == null || points.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DevicePointDto> pointDtos = new ArrayList<DevicePointDto>();
        for (DevicePoint point : points) {
            DevicePointDto pointDto = mapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        log.info(pointDtos.toString());
        return pointDtos;
    }

    public List<DevicePointDto> getZeroIntensityLevelDevicePoints(Long deviceId) {
        List<DevicePoint> devicePoints = (List<DevicePoint>) devicePointRepository.getZeroIntensityLevelDevicePointsByDeviceId(deviceId);
        if (devicePoints == null || devicePoints.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List<DevicePointDto> pointDtos = new ArrayList<DevicePointDto>();
        for (DevicePoint point : devicePoints) {
            DevicePointDto pointDto = mapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        log.info(pointDtos.toString());
        return pointDtos;
    }


}
