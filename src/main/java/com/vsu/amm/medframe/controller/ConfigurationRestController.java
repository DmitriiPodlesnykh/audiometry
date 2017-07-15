package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.model.dto.DevicePointResponse;
import com.vsu.amm.medframe.model.dto.DeviceResponse;
import com.vsu.amm.medframe.service.DevicePointService;
import com.vsu.amm.medframe.service.DeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

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
    public DevicePointResponse getDevicePoint(@PathVariable("deviceId") Long deviceID,
                                              @PathVariable("devicePointId") Long devicePointId) {
        return devicePointService.getOne(devicePointId);
    }

    @RequestMapping(value = "/devices/{deviceId}/generate/allpoints", method = POST)
    public DeviceResponse generatePointsForFullFrequencies(@PathVariable("deviceId") Long deviceID) {
        return deviceService.generateDevicePoints(deviceID);
    }
}
