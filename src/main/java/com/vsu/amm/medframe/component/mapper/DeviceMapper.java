package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.entity.Device;
import org.springframework.stereotype.Component;

@Component
public class DeviceMapper implements Mapper<Device, DeviceDto> {

    @Override
    public Device mapToEntity(DeviceDto deviceDto) {
        Device device = new Device();
        device.setId(deviceDto.getId());
        device.setHeadphoneNsme(deviceDto.getHeadphoneName());
        device.setSoundCardName(deviceDto.getSoundCardName());
        return device;
    }

    @Override
    public DeviceDto mapToDto(Device device) {
        DeviceDto dto = new DeviceDto();
        dto.setSoundCardName(device.getSoundCardName());
        dto.setId(device.getId());
        dto.setHeadphoneName(device.getSoundCardName());
        return dto;
    }
}
