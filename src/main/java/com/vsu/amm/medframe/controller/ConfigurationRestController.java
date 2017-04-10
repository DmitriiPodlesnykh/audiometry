package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.dto.DevicePointDto;
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

    private static final Logger log = Logger.getLogger(ConfigurationRestController.class);

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DevicePointService devicePointService;

    @RequestMapping(value = "/devices", method = PUT)
    public DeviceDto create(@RequestBody DeviceDto deviceDto) {
        deviceDto = deviceService.save(deviceDto);
        return deviceDto;
    }

    @RequestMapping(value = "/devices/{deviceID}", method = PUT)
    public DevicePointDto createPoint(@PathVariable Long deviceID,
                                      @RequestBody @Valid DevicePointDto pointDto) {
        return devicePointService.save(pointDto);
    }

    @RequestMapping(value = "/devices/{deviceId}", method = GET)
    public DeviceDto getDevice(@PathVariable("deviceId") Long deviceID) {
        return deviceService.getOne(deviceID);
    }

    @RequestMapping(value = "/devices/{deviceId}/{devicePointId}", method = GET)
    public DevicePointDto getDevicePoint(@PathVariable("deviceId") Long deviceID,
                                         @PathVariable("devicePointId") Long devicePointId) {
        return devicePointService.getOne(devicePointId);
    }

    @RequestMapping(value = "/devices/{deviceId}", method = POST)
    public DeviceDto updateDevice(@PathVariable("deviceId") Long deviceID,
                                  @RequestBody DeviceDto deviceDto) {
        return deviceService.updateDevice(deviceDto);
    }

    @RequestMapping(value = "/devices/{deviceId}/generate/allpoints", method = POST)
    public DeviceDto generatePointsForFullFrequencies(@PathVariable("deviceId") Long deviceID) {
        return deviceService.generateDevicePoints(deviceID);
    }
}
