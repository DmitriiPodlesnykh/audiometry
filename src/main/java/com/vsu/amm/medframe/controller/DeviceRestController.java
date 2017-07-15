package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.model.dto.CreateDevicePointRequest;
import com.vsu.amm.medframe.model.dto.CreateDeviceRequest;
import com.vsu.amm.medframe.model.dto.DevicePointResponse;
import com.vsu.amm.medframe.model.dto.DeviceResponse;
import com.vsu.amm.medframe.service.DevicePointService;
import com.vsu.amm.medframe.service.DeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("rest/devices")
public class DeviceRestController {

    private static final Logger LOGGER = Logger.getLogger(DeviceRestController.class);

    private final DeviceService deviceService;
    private final DevicePointService devicePointService;

    @Autowired
    public DeviceRestController(
            DeviceService deviceService,
            DevicePointService devicePointService) {
        this.deviceService = deviceService;
        this.devicePointService = devicePointService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getDevices() {
        return deviceService.getAll();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public DeviceResponse create(@RequestBody CreateDeviceRequest deviceResponse) {
        //todo fix it
        //deviceResponse = deviceService.save(deviceResponse);
        //return deviceResponse;
        return new DeviceResponse();
    }

    @RequestMapping(value = "/{deviceId}", method = POST)
    public DeviceResponse updateDevice(@PathVariable("deviceId") Long deviceID,
                                       @RequestBody DeviceResponse deviceResponse) {
        return deviceService.updateDevice(deviceResponse);
    }

    @RequestMapping(value = "/{deviceId}", method = GET)
    public DeviceResponse getDevice(@PathVariable("deviceId") Long deviceID) {
        return deviceService.getOne(deviceID);
    }


    @RequestMapping(value = "/{deviceID}", method = PUT)
    public DevicePointResponse createPoint(@PathVariable Long deviceID,
                                           @RequestBody @Valid CreateDevicePointRequest pointDto) {
        //todo fix it
        //return devicePointService.save(pointDto);
        return new DevicePointResponse();
    }
}
