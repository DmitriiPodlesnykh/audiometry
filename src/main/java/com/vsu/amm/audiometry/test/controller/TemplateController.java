package com.vsu.amm.audiometry.test.controller;

import com.vsu.amm.audiometry.model.dto.TemplateDto;
import com.vsu.amm.audiometry.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.apache.log4j.Logger;

@Controller
@RequestMapping("/templates")
public class TemplateController {

    private static final Logger LOGGER = Logger.getLogger(TemplateController.class);

    @Autowired
    private TemplateService templateService;

    @RequestMapping(value = "", method = GET)
    public String getAll(ModelMap modelMap) {
        modelMap.addAttribute("templates", templateService.getAll());

        LOGGER.info("Before retutn: modelMap = " + modelMap.toString());
        return "templateList";
    }

    @RequestMapping(value = "/add", method = GET)
    public String createForm() {
        return "/addTemplate";
    }

    @RequestMapping(value = "/add", method = POST)
    public String create(@RequestBody TemplateDto jsonTemplateDto) {
        templateService.save(jsonTemplateDto);
        return "redirect:/templates";
    }

    @RequestMapping(value = "/{templateId}/add", method = GET)
    public String createTemplatePointForm(@PathVariable("templateId") Long templateId) {
        return "/addTemplatePoint";
    }

    @RequestMapping(value = "/{templateId}/points", method = GET)
    public String getTemplatePoints(@PathVariable Long templateId, ModelMap modelMap) {
        LOGGER.info("getTemplatePoints");
        //TODO fix it
        //modelMap.addAttribute("templatePoints", templatePointService.getPointsByTemplateId(templateId));
        return "templatePointsForTemplate";
    }

    @RequestMapping(value = "/{templateId}/{pointId}", method = GET)
    public String getTemplatePoint(@PathVariable Long templateId, @PathVariable Long pointId, ModelMap modelMap) {
        LOGGER.info("getTemplatePoint");
        //TODO fix it
        //modelMap.addAttribute("templatePoint", templatePointService.getPointById(pointId));
        return "templatePoint";
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public String delete(@PathVariable Long id) {
        templateService.delete(id);
        return "redirect:/templates";
    }

    @RequestMapping(value = "/{id}", method = GET)
    public String getTemplate(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("template", templateService.getOne(id));
        return "template";
    }
}
