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

import java.util.*;

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

    public Template save(TemplateDto templateDto) {

        log.info("RUN Template save(TemplateDto templateDto)");
        log.info("templateDto = " + templateDto.toString());
        Template template = convertToTemplate(templateDto);
        log.info("Before return template. template = " + template.toString());
        templateRepository.saveAndFlush(template);
        log.info("template saved");
        return template;
    }

    private Template convertToTemplate(TemplateDto dto) {
        Template template = new Template();
        /*
         ~ if dto.getId() !=null =>template.setId(dto.getId)
        * */
        log.info("  userService.getOne(dto.getId()) = " + userService.getOne(dto.getAuthorId()).toString());
        template.setAuthor(userService.getUser(dto.getAuthorId()));
        log.info("template.setDescription + name");
        template.setDescription(dto.getDescription());
        template.setName(dto.getName());
        log.info("success");

        log.info("List<TemplatePointDto> pointDtos = dto.getPoints();");
        Set<TemplatePointDto> pointDtos = dto.getPoints();
        //List<TemplatePointDto> pointDtos = dto.getPoints();

        if (pointDtos != null && !pointDtos.isEmpty()) {
            log.info("success");
            List<TemplatePoint> points = new ArrayList<TemplatePoint>();
            for (TemplatePointDto pointDto : pointDtos) {
                log.info("start foreach TemplatePointDto pointDto : pointDtos");
                TemplatePoint point = convertToTemplatePoint(pointDto, template);
                //TemplatePoint point = convertToTemplatePoint(pointDto, template)
                //что здесь деалать, tempate еще не создан же
                log.info("for(TemplatePointDto pointDto: pointDtos){");
                points.add(point);
            }
        } else {
            log.error("pointDtos is empty");
        }
        log.info("template:");
        log.info(template.toString());
        return template;
    }

    private TemplatePoint convertToTemplatePoint(TemplatePointDto pointDto, Template template) {
        TemplatePoint point = new TemplatePoint();
        point.setId(1000L);//hotfix
        //point.setId(pointDto.getId());
        point.setFrequency(pointDto.getFrequency());
        point.setInrensityValue(pointDto.getIntensityValue());
        point.setTemplate(template);

        return point;
    }

    private List<Template> convertToListTemplates(List<TemplateDto> dtos) {
        List<Template> templates = new ArrayList<Template>();

        for (TemplateDto dto : dtos) {
            Template template = convertToTemplate(dto);
            templates.add(template);
        }

        return templates;
    }

    private TemplatePointDto convertToTemplatePointDto(TemplatePoint templatePoint) {

        TemplatePointDto dto = new TemplatePointDto();

        //dto.setId(templatePoint.getId());
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


        Set<TemplatePoint> points = template.getTemplatePoints();
        Set<TemplatePointDto> pointDtos = new TreeSet<TemplatePointDto>();
        //List<TemplatePoint> points = template.getTemplatePoints();
        //List<TemplatePointDto> pointDtos = new ArrayList<TemplatePointDto>();
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
}
