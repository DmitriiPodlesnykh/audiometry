package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.dto.DeviceDto;
import com.vsu.amm.medframe.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/config")
public class ConfigurationController {

    @Autowired
    private DeviceService deviceService;


    @RequestMapping(value = "", method = GET)
    public String getConfiguration(ModelMap modelMap) {
        return "";
    }

    @RequestMapping(value = "/devices/add", method = GET)
    public String addDeviceForm() {
        return "/addDevice";
    }

    @RequestMapping(value = "/devices/{deviceId}/add", method = GET)
    public String addDevicePointForm(@PathVariable("deviceId") Long deviceId) {
        return "/addDevicePoint";
    }

    @RequestMapping(value = "/devices/{deviceId}", method = GET)
    public String getDevice(@PathVariable("deviceId") Long deviceId,
                            ModelMap modelMap) {
        modelMap.addAttribute("device", deviceService.getOne(deviceId));
        return "getDevice";
    }

    @RequestMapping(value = "/devices")
    public String getDevices(ModelMap modelMap) {
        modelMap.addAttribute("devices", deviceService.getAll());
        return "getAllDevices";
    }

    @RequestMapping(value = "/devices/add", method = POST)
    public String addDevice(@RequestBody DeviceDto dto) {
        deviceService.save(dto);
        return "redirect:/templates";
    }

    @RequestMapping(value = "/select/device", method = GET)
    public String selectDeviceForm() {
        return "";
    }

    @RequestMapping(value = "/select/device", method = POST)
    public String selectDevice() {
        return "";
    }

}
