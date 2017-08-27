package com.vsu.amm.audiometry.test.unit.mapper;

import com.vsu.amm.audiometry.mapper.DeviceMapper;
import com.vsu.amm.audiometry.model.dto.*;
import com.vsu.amm.audiometry.model.entity.Device;
import com.vsu.amm.audiometry.model.entity.DevicePoint;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class DeviceMapperTest {

    private static final Long TEST_DEVICE_ID = 11L;
    private static String TEST_HEADPHONE_NAME = "headphone1";
    private static String TEST_SOUND_CARD_NAME = "sound card1";
    private static final Integer TEST_FREQUENCY_VALUE = 1000;
    private static final int TEST_INTENSITY_LEVEL = 10;
    private static final BigDecimal TEST_VOLUME_VALUE = new BigDecimal("0.5");


    @Test
    public void when_convert_entity_to_deviceResponse_correct() {
        Set<DevicePoint> devicePoints = new TreeSet<DevicePoint>();
        devicePoints.add(new DevicePoint(TEST_INTENSITY_LEVEL, TEST_FREQUENCY_VALUE, TEST_VOLUME_VALUE));
        Device device = new Device(TEST_SOUND_CARD_NAME, TEST_HEADPHONE_NAME, devicePoints);
        device.setId(TEST_DEVICE_ID);

        DeviceResponse dto = DeviceMapper.INSTANCE.toDeviceResponse(device);

        assertEquals(dto.getId(), TEST_DEVICE_ID);
        assertEquals(dto.getPoints().size(), 1);
        assertEquals(dto.getHeadphoneName(), TEST_HEADPHONE_NAME);
        assertEquals(dto.getSoundCardName(), TEST_SOUND_CARD_NAME);
    }

    @Test
    public void when_convert_deviceResponse_to_entity_correct() {
        Set<DevicePointResponse> pointElements = new TreeSet<>();

        DevicePointResponse pointElement = new DevicePointResponse();
        pointElement.setFrequency(TEST_FREQUENCY_VALUE);
        pointElement.setIntensityLevel(TEST_INTENSITY_LEVEL);
        pointElement.setVolumeValue(TEST_VOLUME_VALUE.doubleValue());
        pointElements.add(pointElement);

        DeviceResponse dto = new DeviceResponse(TEST_SOUND_CARD_NAME, TEST_HEADPHONE_NAME, TEST_DEVICE_ID, pointElements);

        Device entity = DeviceMapper.INSTANCE.fromDeviceResponse(dto);
        assertEquals(entity.getId(), TEST_DEVICE_ID);
        assertEquals(entity.getDevicePoints().size(), 1);
        assertEquals(entity.getHeadphoneName(), TEST_HEADPHONE_NAME);
        assertEquals(entity.getSoundCardName(), TEST_SOUND_CARD_NAME);
    }

    @Test
    public void when_convert_createDeviceRequest_to_entity_correct() {
        Set<CreateDevicePointRequest> pointRequests = new HashSet<CreateDevicePointRequest>();
        pointRequests.add(new CreateDevicePointRequest(TEST_DEVICE_ID, TEST_FREQUENCY_VALUE,
                TEST_INTENSITY_LEVEL, TEST_VOLUME_VALUE.doubleValue()));
        CreateDeviceRequest dto = new CreateDeviceRequest(TEST_SOUND_CARD_NAME, TEST_HEADPHONE_NAME, pointRequests);

        Device entity = DeviceMapper.INSTANCE.toEntity(dto);

        assertEquals(entity.getDevicePoints().size(), 1);
        assertEquals(entity.getHeadphoneName(), TEST_HEADPHONE_NAME);
        assertEquals(entity.getSoundCardName(), TEST_SOUND_CARD_NAME);
    }

}
