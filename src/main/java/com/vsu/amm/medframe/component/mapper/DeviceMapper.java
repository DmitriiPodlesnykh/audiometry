package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.entity.Device;
import com.vsu.amm.medframe.entity.DevicePoint;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.vsu.amm.medframe.dto.DevicePointDto;

@Component
public class DeviceMapper implements Mapper<Device, DeviceDto> {

    private static final Logger log = Logger.getLogger(DeviceMapper.class);

    @Autowired
    private DevicePointMapper devicePointMapper;

    @Override
    public Device mapToEntity(DeviceDto deviceDto) {
        Device device = new Device();
        device.setId(deviceDto.getId());
        device.setHeadphoneName(deviceDto.getHeadphoneName());
        device.setSoundCardName(deviceDto.getSoundCardName());
        return device;
    }

    @Override
    public DeviceDto mapToDto(Device device) {
        DeviceDto dto = new DeviceDto();
        dto.setSoundCardName(device.getSoundCardName());
        dto.setId(device.getId());
        dto.setHeadphoneName(device.getHeadphoneName());

        if(device.getDevicePoints() != null && !device.getDevicePoints().isEmpty()) {
            List<DevicePointDto> points = new ArrayList<DevicePointDto>();
            for (DevicePoint point : device.getDevicePoints()) {
                DevicePointDto pointDto = devicePointMapper.mapToDto(point);
                log.info(point);
                points.add(pointDto);
            }
            dto.setPointList(points);
        } else {
            log.info("device don't have points");
        }
        return dto;
    }
}
