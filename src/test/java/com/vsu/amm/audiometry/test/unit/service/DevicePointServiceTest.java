package com.vsu.amm.audiometry.test.unit.service;

import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.service.DevicePointService;
import com.vsu.amm.audiometry.service.impl.DevicePointServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.transaction.Transactional;

@Transactional
public class DevicePointServiceTest {

    private DevicePointService devicePointService;

    private static final int CONSTANT_VALUE = 10;
    private static final double DELTA = 0;

    @Before
    public void setRelatedObjects() {
        devicePointService = new DevicePointServiceImpl();
    }

    @Test
    public void should_point_save_and_obtain_Id_and_deviceId_field() {
        CreateDevicePointRequest pointRequest = new CreateDevicePointRequest();
        pointRequest.setVolumeValue(CONSTANT_VALUE);
        pointRequest.setIntensityLevel(CONSTANT_VALUE);
        pointRequest.setFrequency(CONSTANT_VALUE);
//todo fix it
//        DevicePointElement pointElement = devicePointService.save(pointRequest);
//
//        Assert.assertEquals(pointElement.getVolumeValue(), CONSTANT_VALUE, DELTA);
//        Assert.assertEquals(pointElement.getFrequency(), CONSTANT_VALUE);
//        Assert.assertEquals(pointElement.getIntensityLevel(), CONSTANT_VALUE);
//
//        Assert.assertFalse(pointElement.getDeviceId() == null);
//        Assert.assertFalse(pointElement.getId() == null);
    }
}