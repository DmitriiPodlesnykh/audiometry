package com.vsu.amm.medframe.service.Impl;


import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.repository.TemplateRepository;
import com.vsu.amm.medframe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

@Service
public class TemplateServiceImpl implements TemplateService {

    private static final Logger log = Logger.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Template save(TemplateDto templateDto) {

        log.info("RUN Template save(TemplateDto templateDto)");
        log.info("templateDto = " + templateDto.toString());

        Template template = new Template();

        template.setName(templateDto.getName());
        template.setDescription(template.getDescription());
        template.setAuthor(userService.getOne(templateDto.getAuthorId()));
        log.info("Before return template. template = " + template.toString());
        return template;
    }


    @Override
    public List<TemplateDto> getAll() {
        log.info("RUN List<TemplateDto> getAll()");
        List<Template> templates = templateRepository.findAll();
        List<TemplateDto> templateDtos = new ArrayList<TemplateDto>();
        for (Template template : templates) {
            log.info("in for:");
            log.info("template = " + template.toString());
            TemplateDto templateDto = new TemplateDto();
            templateDto.setId(template.getId());
            templateDto.setName(template.getName());
            templateDto.setDescription(template.getDescription());

            //log.info("templateDto = " + templateDto.toString());

            templateDtos.add(templateDto);
        }
        //log.info("after for:");
        //log.info("templateDtos = " + templateDtos.toString());
        return templateDtos;
    }


    @Override
    public Template getOne(Long id) {
        return templateRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        templateRepository.delete(id);
    }

    public void methodForTest() {
        log.info("start methodForTest()");
        System.out.println("start methodForTest()");
        Template template = templateRepository.findTemplateWithAuthorByIdQ(1L);
        //Template template = templateRepository.findWithTemplatePointsByIdQ(1L);
        System.out.println("template.getName" + template.getName());
        log.info("template.getName" + template.getName());
        System.out.println("template author = " + template.getAuthor().getLastName());
        log.info("finish methodForTest()");
    }
}
