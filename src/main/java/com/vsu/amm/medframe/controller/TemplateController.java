package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.service.Impl.TemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/templates")
public class TemplateController {

    /*
    @Autowired
    private TemplateServiceImpl templateService;

    @RequestMapping(value = "", method = GET)
    public String getAll(ModelMap modelMap){
        modelMap.addAttribute("templates", templateService.getAll());
        return "template/templateList";
    }
*/

}
