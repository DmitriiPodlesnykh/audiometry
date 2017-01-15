package com.vsu.amm.medframe.service;


import com.github.jmnarloch.spring.boot.modelmapper.ModelMapperAutoConfiguration;
import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

@Service
public class TemplateServiceImpl {

    private static final Logger log = Logger.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TemplatePointServiceImpl templatePointService;

    //@Autowired
    //private ModelMapper

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


    private TemplatePointDto convertToTemplatePointDto(TemplatePoint templatePoint) {

        TemplatePointDto dto = new TemplatePointDto();

        dto.setId(templatePoint.getId());
        dto.setFrequency(templatePoint.getFrequency());
        dto.setIntensityValue(templatePoint.getInrensityValue());

        return dto;
    }

    private TemplateDto convertToTemplateDto(Template template) {

        TemplateDto dto = new TemplateDto();
        dto.setName(template.getName());
        dto.setId(template.getId());
        dto.setAuthorId(template.getAuthor().getId());
        dto.setDescription(template.getDescription());


        List<TemplatePoint> points = template.getTemplatePoints();
        List<TemplatePointDto> pointDtos = new ArrayList<TemplatePointDto>();
        for (TemplatePoint point : points) {
            TemplatePointDto templatePointDto = convertToTemplatePointDto(point);
            pointDtos.add(templatePointDto);
        }
        dto.setPoints(pointDtos);

        return dto;
    }

    private List<TemplateDto> convertToListTemplateDtos(List<Template> templates) {
        if (templates == null || templates.isEmpty()) {
            List<TemplateDto> dtos = Collections.EMPTY_LIST;
            return dtos;
        }
        List<TemplateDto> dtos = new ArrayList<TemplateDto>();

        for (Template t : templates) {
            TemplateDto templateDto = convertToTemplateDto(t);
            dtos.add(templateDto);
        }
        return dtos;
    }

    public List<TemplateDto> getAll() {
        List<Template> templates = templateRepository.findAll();
        List<TemplateDto> templateDtos = convertToListTemplateDtos(templates);

        return templateDtos;
    }


    public Template getOne(Long id) {
        return templateRepository.findOne(id);
    }

    public void delete(Long id) {
        templateRepository.delete(id);
    }

    public void methodForTest() {
        log.info("start methodForTest()");
        System.out.println("start methodForTest()");


        Template template = templateRepository.findWithTemplatePointsByIdQ(1L);
        //Template template = templateRepository.findWithTemplatePointsByIdQ(1L);
        System.out.println("template.getName" + template.getName());
        log.info("template.getName" + template.getName());
        System.out.println("template author = " + template.getAuthor().getLastName());
        log.info("finish methodForTest()");
    }
}
