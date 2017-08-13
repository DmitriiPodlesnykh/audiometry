package com.vsu.amm.audiometry.test.unit.mapper;

import com.vsu.amm.audiometry.mapper.DevicePointMapper;
import com.vsu.amm.audiometry.model.entity.Device;
import org.junit.Test;
import org.mockito.Mock;

public class DeviceMapperTest {

    Device device;

    @Mock
    DevicePointMapper pointMapper;


    private static final Long TEST_DEVICE_ID = 11L;
    private static String TEST_HEADPHONE_NAME = "headphone1";
    private static String TEST_SOUND_CARD_NAME = "sound card1";

    @Test
    public void when_convert_entity_to_createDeviceRequest_correct() {

        device = new Device(TEST_SOUND_CARD_NAME, TEST_HEADPHONE_NAME, null );
    }

    @Test
    public void when_convert_entity_to_deviceResponse_correct() {

    }

    @Test
    public void when_convert_deviceResponse_to_entity_correct() {

    }

    @Test
    public void when_convert_createDeviceRequest_to_entity_correct() {

    }

}
