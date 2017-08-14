package com.vsu.amm.audiometry.test.unit.mapper;

import com.vsu.amm.audiometry.mapper.DevicePointMapper;
import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.entity.Device;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class DevicePointMapperTest {

    private Device device;

    private static final Integer TEST_FREQUENCY_VALUE = 1000;
    private static final int TEST_INTENSITY_LEVEL = 10;
    private static final Long TEST_DEVICE_ID = 111L;
    private static final Long TEST_ID = 1111L;
    private static final BigDecimal TEST_VOLUME_VALUE = new BigDecimal("0.5");
    private static final double DELTA = 0;

    @Before
    public void setup() {

       device = new Device();
       device.setId(TEST_DEVICE_ID);
    }

    @Test
    public void when_convert_entity_to_createDevicePointRequest_correct() {
        DevicePoint entity = new DevicePoint(TEST_INTENSITY_LEVEL, TEST_FREQUENCY_VALUE, TEST_VOLUME_VALUE);

        CreateDevicePointRequest dto = DevicePointMapper.INSTANCE.toCreateDevicePointRequest(entity);

        assertEquals(dto.getIntensityLevel(), TEST_INTENSITY_LEVEL);
        assertEquals(dto.getVolumeValue(), TEST_VOLUME_VALUE.doubleValue(), DELTA);
        assertEquals(dto.getFrequency(), TEST_FREQUENCY_VALUE.intValue());
    }

    @Test
    public void when_convert_createDevicePointRequest_to_entity_correct() {
        CreateDevicePointRequest dto = new CreateDevicePointRequest();
        dto.setVolumeValue(TEST_VOLUME_VALUE.doubleValue());
        dto.setFrequency(TEST_FREQUENCY_VALUE);
        dto.setIntensityLevel(TEST_INTENSITY_LEVEL);

        DevicePoint entity = DevicePointMapper.INSTANCE.fromCreateDevicePointRequest(dto);

        assertEquals(entity.getFrequency(), TEST_FREQUENCY_VALUE);
        assertEquals(entity.getIntensityLevel(), TEST_INTENSITY_LEVEL, DELTA);
        assertEquals(entity.getVolumeValue(), TEST_VOLUME_VALUE);
    }

    @Test
    public void when_convert_entity_to_devicePointElement_correct() {
        DevicePoint entity = new DevicePoint(device, TEST_INTENSITY_LEVEL, TEST_FREQUENCY_VALUE,
                TEST_VOLUME_VALUE, null);

        DevicePointElement dto = DevicePointMapper.INSTANCE.toDevicePointElement(entity);

        assertEquals(dto.getIntensityLevel(), TEST_INTENSITY_LEVEL);
        assertEquals(dto.getFrequency(), TEST_FREQUENCY_VALUE.intValue());
        assertEquals(dto.getVolumeValue(), TEST_VOLUME_VALUE.doubleValue(), DELTA);
        assertEquals(dto.getDeviceId(), TEST_DEVICE_ID);
        //assertEquals(dto.get);
    }

    @Test
    public void when_convert_devicePointElement_to_entity_correct() {
        DevicePointElement dto = new DevicePointElement();
        dto.setVolumeValue(TEST_VOLUME_VALUE.doubleValue());
        dto.setDeviceId(TEST_DEVICE_ID);
        dto.setId(TEST_ID);
        dto.setFrequency(TEST_FREQUENCY_VALUE);
        dto.setIntensityLevel(TEST_INTENSITY_LEVEL);

        DevicePoint entity = DevicePointMapper.INSTANCE.fromDevicePointElement(dto);

        assertEquals(entity.getFrequency(), TEST_FREQUENCY_VALUE);
        assertEquals(entity.getIntensityLevel(), TEST_INTENSITY_LEVEL, DELTA);
        assertEquals(entity.getVolumeValue(), TEST_VOLUME_VALUE);
        assertEquals(entity.getDevice().getId(), TEST_DEVICE_ID);
        assertEquals(entity.getId(), TEST_ID);
    }

    @Test
    public void when_convert_createDevicePointRequestPointsSet_to_DevicePointsSet() {
        Set<CreateDevicePointRequest> dtos = new TreeSet<CreateDevicePointRequest>();

        CreateDevicePointRequest dto1 = new CreateDevicePointRequest();
        dto1.setVolumeValue(TEST_VOLUME_VALUE.doubleValue());
        dto1.setIntensityLevel(TEST_INTENSITY_LEVEL);
        dto1.setFrequency(TEST_FREQUENCY_VALUE);
        dtos.add(dto1);

        Set<DevicePoint> entitySet = DevicePointMapper.INSTANCE.createDevicePointRequestPointsToDevicePoints(dtos);

        DevicePoint entity = entitySet.iterator().next();

        assertEquals(entity.getFrequency(), TEST_FREQUENCY_VALUE);
        assertEquals(entity.getIntensityLevel(), TEST_INTENSITY_LEVEL, DELTA);
        assertEquals(entity.getVolumeValue(), TEST_VOLUME_VALUE);
    }
}