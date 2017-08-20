package com.vsu.amm.audiometry.controller;

import com.vsu.amm.audiometry.model.dto.CreateDevicePointRequest;
import com.vsu.amm.audiometry.model.dto.CreateDeviceRequest;
import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.model.dto.DeviceResponse;
import com.vsu.amm.audiometry.service.DevicePointService;
import com.vsu.amm.audiometry.service.DeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

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
    public DeviceResponse create(@RequestBody CreateDeviceRequest dto) {
        return deviceService.save(dto);
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
    public DevicePointElement createPoint(@PathVariable Long deviceID,
                                          @RequestBody @Valid CreateDevicePointRequest pointDto) {
        //todo fix it
        //return devicePointService.save(pointDto);
        return new DevicePointElement();
    }
}
