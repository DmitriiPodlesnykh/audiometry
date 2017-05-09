package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.entity.DevicePoint;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.vsu.amm.medframe.dto.DevicePointDto;

@Component
public class DeviceMapper implements Mapper<Device, DeviceDto> {

    private static final Logger LOGGER = Logger.getLogger(DeviceMapper.class);

    @Autowired
    private DevicePointMapper devicePointMapper;

    @Override
    public Device mapToEntity(DeviceDto deviceDto) {
        Device device = new Device();
        device.setId(deviceDto.getId());
        device.setHeadphoneName(deviceDto.getHeadphoneName());
        device.setSoundCardName(deviceDto.getSoundCardName());

        device.setDevicePoints(mapPointDtoCollectionToPoint(deviceDto.getPointList()));
        return device;
    }

    @Override
    public DeviceDto mapToDto(Device device) {
        DeviceDto dto = new DeviceDto();
        dto.setSoundCardName(device.getSoundCardName());
        dto.setId(device.getId());
        dto.setHeadphoneName(device.getHeadphoneName());

        if (device.getDevicePoints() != null && !device.getDevicePoints().isEmpty()) {
            dto.setPointList(mapPointCollectionToDto(device.getDevicePoints()));
        } else {
            LOGGER.info("device don't have points");
        }
        return dto;
    }

    private List<DevicePointDto> mapPointCollectionToDto(Collection<DevicePoint> points) {
        List<DevicePointDto> pointDtos = new ArrayList<DevicePointDto>();
        for (DevicePoint point : points) {
            DevicePointDto pointDto = devicePointMapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        return pointDtos;
    }

    private List<DevicePoint> mapPointDtoCollectionToPoint(Collection<DevicePointDto> pointDtos) {
        List<DevicePoint> points = new ArrayList<DevicePoint>();
        for (DevicePointDto pointDto : pointDtos) {
            DevicePoint point = devicePointMapper.mapToEntity(pointDto);
            points.add(point);
        }
        return points;
    }
}
