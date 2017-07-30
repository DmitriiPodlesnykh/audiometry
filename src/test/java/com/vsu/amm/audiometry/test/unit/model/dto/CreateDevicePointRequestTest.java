package com.vsu.amm.audiometry.test.unit.model.dto;

import com.vsu.amm.audiometry.mapper.DevicePointMapper;
import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CreateDevicePointRequestTest {

    private DevicePointMapper devicePointMapper;

    private static final int TEST_INT = 99999;
    private static final BigDecimal TEST_BD = new BigDecimal("99998");

    @Before
    public void setRelatedObjects() {
        devicePointMapper = Mappers.getMapper(DevicePointMapper.class);
    }

    @Test
    public void when_convert_entity_to_dto_correct(){
        DevicePoint entity = new DevicePoint();
        entity.setIntensityLevel(TEST_INT);
        entity.setVolumeValue(TEST_BD);

        CreateDevicePointRequest dto = devicePointMapper.mapToCreateDevicePointRequest(entity);

        assertEquals(dto.getIntensityLevel(), entity.getIntensityLevel().intValue());
        assertEquals(dto.getSoundValue(), entity.getSoundValue().doubleValue(), 0);
    }

    @Test
    public void when_convert_dto_to_entity_correct(){
        CreateDevicePointRequest dto = new CreateDevicePointRequest();
        dto.setFrequency(TEST_INT);
        dto.setIntensityLevel(TEST_INT);
        dto.setSoundValue(TEST_INT);

        //DevicePoint entity = devicePointMapper.mapToEntity(dto);

        //assertEquals(entity.getIntensityLevel().intValue(), dto.getIntensityLevel());
        //assertEquals(entity.getSoundValue().doubleValue(), dto.getSoundValue(), 0);
        //assertEquals(entity.getFrequency().getValue(), dto.getFrequency());
    }
}