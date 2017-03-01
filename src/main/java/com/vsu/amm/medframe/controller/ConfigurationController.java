package com.vsu.amm.medframe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/config")
public class ConfigurationController {

    @RequestMapping(value = "", method = GET)
    public String getConfiguration(ModelMap modelMap){
        return "";
    }

    @RequestMapping(value = "/add/device", method = GET)
    public String addDeviceForm(){
        return "";
    }

    @RequestMapping(value = "add/device", method = POST)
    public String addDevice(){
        return "";
    }

    @RequestMapping(value = "/select/device", method = GET)
    public String selectDeviceForm(){
        return "";
    }

    @RequestMapping(value = "/select/device", method = POST)
    public String selectDevice(){
        return "";
    }

}
