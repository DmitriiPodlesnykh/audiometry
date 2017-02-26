package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.service.TemplatePointServiceImpl;
import com.vsu.amm.medframe.service.TemplateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.apache.log4j.Logger;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/templates")
public class TemplateController {

    private static final Logger log = Logger.getLogger(TemplateController.class);

    @Autowired
    private TemplateServiceImpl templateService;

    @Autowired
    private TemplatePointServiceImpl templatePointService;

    @RequestMapping(value = "", method = GET)
    public String getAll(ModelMap modelMap) {
        log.info("RUN getAll(ModelMap modelMap)");
        modelMap.addAttribute("templates", templateService.getAll());

        log.info("Before retutn: modelMap = " + modelMap.toString());
        return "templateList";
    }

    @RequestMapping(value = "/add", method = GET)
    public String createForm() {
        return "/addTemplate";
    }


    /*@RequestMapping(value = "/add", method = POST)
    public String create(@ModelAttribute("template") TemplateDto templateDto) {
        log.info("RUN create(@ModelAttribute(\"template\") TemplateDto templateDto)");
        if (templateDto.getPoints() != null)
            log.info("templateDto.getPoints() ==" + templateDto.getPoints().toString());
        else
            log.info("templateDto.getPoints() == NULL");
        templateService.save(templateDto);
        return "redirect:/templates";
    }*/

    @RequestMapping(value = "/add", method = POST)
    public String create(@RequestBody TemplateDto jsonTemplateDto){
        templateService.save(jsonTemplateDto);
        return "redirect:/templates";
    }

    @RequestMapping(value="/{templateId}/add", method = GET)
    public String createTemplatePointForm(@PathVariable("templateId") Long templateId){
        return "/addTemplatePoint";
    }

    @RequestMapping(value = "/{templateId}/add", method = POST)
    public String createTemplatePoint(@PathVariable Long templateId, @RequestBody @Valid TemplatePointDto jsonPointDto){
        log.info("createTemplatePoint");
        log.info("templateId = " + templateId.toString());
        log.info("dto = " + jsonPointDto.toString());
        templatePointService.save(jsonPointDto);
        return "templateList";
    }

    @RequestMapping(value = "/{templateId}/points", method = GET)
    public String getTemplatePoints(@PathVariable Long templateId, ModelMap modelMap){
        log.info("getTemplatePoints");
        modelMap.addAttribute("templatePoints", templatePointService.getPointForTemplate(templateId));

        return "templatePointsForTemplate";
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

    /*@RequestMapping(value = "/{id}/add", method = POST)
    public String createTemplatePoint(@PathVariable Long templateId,
                                      @ModelAttribute("templatePoint") TemplatePointDto templatePointDto) {
        templatePointService.save(templatePointDto);

        StringBuilder returnUrl = new StringBuilder("redirect:/templates/");
        returnUrl.append(templateId);
        return returnUrl.toString();
    }*/
}
