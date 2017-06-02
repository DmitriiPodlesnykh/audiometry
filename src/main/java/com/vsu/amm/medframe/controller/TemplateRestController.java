package com.vsu.amm.medframe.controller;

import com.vsu.amm.medframe.model.dto.TemplateDto;
import com.vsu.amm.medframe.model.dto.TemplatePointDto;
import com.vsu.amm.medframe.service.TemplatePointService;
import com.vsu.amm.medframe.service.TemplateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping("/rest/templates")
public class TemplateRestController {

    private static final Logger LOGGER = Logger.getLogger(TemplateRestController.class);

    @Autowired
    private TemplateService templateService;

    @Autowired
    private TemplatePointService templatePointService;

    @RequestMapping(value = "", method = POST)
    public TemplateDto create(@RequestBody TemplateDto jsonTemplateDto) {
        jsonTemplateDto = templateService.save(jsonTemplateDto);
        LOGGER.info(jsonTemplateDto.toString());
        return jsonTemplateDto;
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public TemplateDto update(@PathVariable Long id, @RequestBody @Valid TemplateDto templateDto){
        return new TemplateDto();
    }

    @RequestMapping(value = "/{templateId}", method = POST)
    public TemplatePointDto createTemplatePoint(@PathVariable Long templateId, @RequestBody @Valid TemplatePointDto jsonPointDto) {
        TemplatePointDto pointDto = templatePointService.save(jsonPointDto);
        return pointDto;
    }
}
