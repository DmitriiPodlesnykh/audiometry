package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.model.dto.DeviceResponse;
import com.vsu.amm.medframe.enums.Frequency;
import com.vsu.amm.medframe.service.DevicePointService;
import com.vsu.amm.medframe.service.DeviceService;
import org.apache.log4j.Logger;
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

    private static final Logger LOGGER = Logger.getLogger(ConfigurationController.class);

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private DevicePointService devicePointService;

    @RequestMapping(value = "/devices/new", method = GET)
    public String getAddDeviceForm(ModelMap modelMap) {
        return "addDeviceByThePoint";
    }

    @RequestMapping(value = "", method = GET)
    public String getConfiguration(ModelMap modelMap) {
        return "/";
    }

    @RequestMapping(value = "/devices/add", method = GET)
    public String addDeviceForm() {
        return "/addDevice";
    }

    @RequestMapping(value = "/devices/{deviceId}/add", method = GET)
    public String addDevicePointForm(@PathVariable("deviceId") Long deviceId, ModelMap modelMap) {
        modelMap.addAttribute("frequencyListValues", Frequency.getAvailableValues());
        return "/addDevicePoint";
    }

    @RequestMapping(value = "/devices/{deviceId}/{devicePointId}", method = GET)
    public String getDevicePoint(@PathVariable("deviceId") Long deviceId,
                                 @PathVariable("devicePointId") Long devicePointId,
                                 ModelMap modelMap) {
        modelMap.addAttribute("devicePoint", devicePointService.getOne(devicePointId));
        return "getDevicePoint";
    }

    @RequestMapping(value = "/devices/{deviceId}/points", method = GET)
    public String getDevicePoints(@PathVariable("deviceId") Long deviceId, ModelMap modelMap) {
        modelMap.addAttribute("devicePoints", devicePointService.getDevicePoints(deviceId));
        return "getDevicePoints";
    }

    @RequestMapping(value = "/devices/{deviceId}", method = GET)
    public String getDevice(@PathVariable("deviceId") Long deviceId,
                            ModelMap modelMap) {
        DeviceResponse deviceResponse = deviceService.getOne(deviceId);
        modelMap.addAttribute("device", deviceResponse);
        return "getDevice";
    }

    @RequestMapping(value = "/devices")
    public String getDevices(ModelMap modelMap) {
        modelMap.addAttribute("devices", deviceService.getAll());
        return "getAllDevices";
    }

    @RequestMapping(value = "/devices/add", method = POST)
    public String addDevice(@RequestBody DeviceResponse dto) {
        //todo fix it
        //deviceService.save(dto);
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
