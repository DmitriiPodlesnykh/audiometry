package com.vsu.amm.audiometry.test.unit.controller;

import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.dto.DeviceResponse;
import com.vsu.amm.audiometry.service.DevicePointService;
import com.vsu.amm.audiometry.service.DeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest/configuration")
public class ConfigurationRestController {

    private static final Logger LOGGER = Logger.getLogger(ConfigurationRestController.class);

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DevicePointService devicePointService;


    @RequestMapping(value="/devices/new", method = GET)
    public DeviceResponse getAddDeviceForm(@RequestBody DeviceResponse deviceResponse) {
        return deviceService.generatedPointsAndSave(deviceResponse);
    }

    @RequestMapping(value = "/devices/{deviceId}/{devicePointId}", method = GET)
    public DevicePointElement getDevicePoint(@PathVariable("deviceId") Long deviceID,
                                             @PathVariable("devicePointId") Long devicePointId) {
        return devicePointService.getOne(devicePointId);
    }

    @RequestMapping(value = "/devices/{deviceId}/generate/allpoints", method = POST)
    public DeviceResponse generatePointsForFullFrequencies(@PathVariable("deviceId") Long deviceID) {
        return deviceService.generateDevicePoints(deviceID);
    }
}
