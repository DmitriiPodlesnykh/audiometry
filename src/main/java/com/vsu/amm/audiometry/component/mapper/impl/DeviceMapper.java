package com.vsu.amm.audiometry.component.mapper.impl;

import com.vsu.amm.audiometry.component.mapper.Mapper;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.dto.DeviceResponse;
import com.vsu.amm.audiometry.model.entity.Device;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class DeviceMapper implements Mapper<Device, DeviceResponse> {

    private static final Logger LOGGER = Logger.getLogger(DeviceMapper.class);

    @Autowired
    private DevicePointMapper devicePointMapper;

    @Override
    public Device mapToEntity(DeviceResponse deviceResponse) {
        Device device = new Device();
        device.setId(deviceResponse.getId());
        device.setHeadphoneName(deviceResponse.getHeadphoneName());
        device.setSoundCardName(deviceResponse.getSoundCardName());
//fix it
        //device.setDevicePoints(mapPointDtoCollectionToPoint(deviceResponse.getPointList()));
        return device;
    }

    @Override
    public DeviceResponse mapToDto(Device device) {
        DeviceResponse dto = new DeviceResponse();
        dto.setSoundCardName(device.getSoundCardName());
        dto.setId(device.getId());
        dto.setHeadphoneName(device.getHeadphoneName());

        if (device.getDevicePoints() != null && !device.getDevicePoints().isEmpty()) {
            //fix it
            //dto.setPointList(mapPointCollectionToDto(device.getDevicePoints()));
        } else {
            LOGGER.info("device don't have points");
        }
        return dto;
    }

    private List<DevicePointElement> mapPointCollectionToDto(Collection<DevicePoint> points) {
        List<DevicePointElement> pointDtos = new ArrayList<DevicePointElement>();
        for (DevicePoint point : points) {
            DevicePointElement pointDto = devicePointMapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        return pointDtos;
    }

    private List<DevicePoint> mapPointDtoCollectionToPoint(Collection<DevicePointElement> pointDtos) {
        List<DevicePoint> points = new ArrayList<DevicePoint>();
        for (DevicePointElement pointDto : pointDtos) {
            DevicePoint point = devicePointMapper.mapToEntity(pointDto);
            points.add(point);
        }
        return points;
    }
}
