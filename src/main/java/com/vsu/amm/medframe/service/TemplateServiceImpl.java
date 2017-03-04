package com.vsu.amm.medframe.service;


import com.vsu.amm.medframe.component.mapper.TemplateMapper;
import com.vsu.amm.medframe.component.mapper.TemplatePointMapper;
import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.log4j.Logger;

@Service
public class TemplateServiceImpl {

    private static final Logger log = Logger.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private TemplatePointMapper pointMapper;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TemplatePointServiceImpl templatePointService;

    public TemplateDto save(TemplateDto templateDto) {
        log.info("templateDto = " + templateDto.toString());
        Template template = convertToTemplate(templateDto);
        template = templateRepository.saveAndFlush(template);
        if(templateDto.getPoints() != null && !templateDto.getPoints().isEmpty()){
            Set<TemplatePoint> points = new TreeSet<TemplatePoint>();
            for (TemplatePointDto pointDto : templateDto.getPoints()) {
                pointDto.setTemplateId(template.getId());
                log.info(pointDto.toString());
                pointDto = templatePointService.save(pointDto);
                TemplatePoint point = pointMapper.mapToEntity(pointDto);
                points.add(point);
            }
            template.setTemplatePoints(points);
            log.info("template.getTemplatePoints() = " + template.getTemplatePoints());
            template = templateRepository.saveAndFlush(template);
        }
        TemplateDto newTemplateDto = templateMapper.mapToDto(template);
        log.info("template saved");
        return newTemplateDto;
    }

    private Template convertToTemplate(TemplateDto dto) {
        Template template = new Template();
        template.setAuthor(userService.getUser(dto.getAuthorId()));
        template.setDescription(dto.getDescription());
        template.setName(dto.getName());
        return template;
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
