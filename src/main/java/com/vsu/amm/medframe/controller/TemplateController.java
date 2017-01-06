package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.service.Impl.TemplateServiceImpl;
import com.vsu.amm.medframe.service.TemplatePointService;
import com.vsu.amm.medframe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private TemplateServiceImpl templateService;

    @Autowired
    private TemplatePointService templatePointService;

    @RequestMapping(value = "", method = GET)
    public String getAll(ModelMap modelMap) {
        modelMap.addAttribute("templates", templateService.getAll());
        return "template/templateList";
    }

    @RequestMapping(value = "/add", method = GET)
    public String createForm() {
        return "/template/addTemplate";
    }

    @RequestMapping(value = "/add", method = POST)
    public String create(@ModelAttribute("template") Template template) {
        templateService.save(template);
        return "redirect:/templates";
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public String delete(@PathVariable Long id) {
        templateService.delete(id);
        return "redirect:/templates";
    }

    @RequestMapping(value = "/{id}", method = GET)
    public String getTemplate(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("template", templateService.getOne(id));
        return "template/template";
    }

    @RequestMapping(value = "/{id}/add", method = POST)
    public String createTemplatePoint(@PathVariable Long templateId,
                                      @ModelAttribute("templatePoint") TemplatePoint templatePoint) {
        templatePointService.save(templatePoint);

        StringBuilder returnUrl = new StringBuilder("redirect:/templates/");
        returnUrl.append(templateId);
        return returnUrl.toString();
    }

}
