package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.service.DeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest/configuration")
public class ConfigurationRestController {

    private static final Logger log = Logger.getLogger(ConfigurationRestController.class);

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/device", method = POST)
    public DeviceDto create(@RequestBody DeviceDto deviceDto){

        deviceDto = deviceService.save(deviceDto);
        return deviceDto;
    }

}
