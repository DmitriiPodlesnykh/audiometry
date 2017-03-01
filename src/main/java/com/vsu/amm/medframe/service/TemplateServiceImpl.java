package com.vsu.amm.medframe.service;


import com.vsu.amm.medframe.component.mapper.TemplateMapper;
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
    private TemplateRepository templateRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TemplatePointServiceImpl templatePointService;

    public TemplateDto save(TemplateDto templateDto) {
        log.info("templateDto = " + templateDto.toString());
        //Template template = templateMapper.mapToEntity(templateDto);
        Template template = convertToTemplate(templateDto);
        templateRepository.saveAndFlush(template);
        if(templateDto.getPoints() != null && !templateDto.getPoints().isEmpty()){
            Set<TemplatePoint> points = new TreeSet<TemplatePoint>();
            for (TemplatePointDto pointDto : templateDto.getPoints()) {
                TemplatePoint point = convertToTemplatePoint(pointDto, template);
                points.add(point);
                log.info("pointDto: " + pointDto.toString() +"; point: " + point.toString());
            }
            log.info(points.size());
            template.setTemplatePoints(points);
        }
        Template newTemplate = templateRepository.saveAndFlush(template);
        TemplateDto newTemplateDto = templateMapper.mapToDto(newTemplate);
        log.info("template saved");
        return newTemplateDto;
    }

    private Template convertToTemplate(TemplateDto dto) {
        Template template = new Template();
        /*
         ~ if dto.getId() !=null =>template.setId(dto.getId)
        * */
        template.setAuthor(userService.getUser(dto.getAuthorId()));
        template.setDescription(dto.getDescription());
        template.setName(dto.getName());
        Set<TemplatePointDto> pointDtos = dto.getPoints();
        if (pointDtos != null && !pointDtos.isEmpty()) {
            log.info("pointDtos.size()" + pointDtos.size());
            Set<TemplatePoint> points = new TreeSet<TemplatePoint>();
            for (TemplatePointDto pointDto : pointDtos) {
                TemplatePoint point = convertToTemplatePoint(pointDto, template);
                points.add(point);
                log.info("pointDto: " + pointDto.toString() +"; point: " + point.toString());
            }
            log.info(points.size());
            template.setTemplatePoints(points);
        } else {
            log.error("pointDtos is empty");
        }
        log.info("template:");
        log.info(template.toString());
        return template;
    }

    private TemplatePoint convertToTemplatePoint(TemplatePointDto pointDto, Template template) {
        try {
            TemplatePoint point = new TemplatePoint();
            point.setFrequency(pointDto.getFrequency());
            point.setInrensityValue(pointDto.getIntensityValue());
            point.setTemplate(template);
            return point;
        }catch (Exception e){
            log.error(e.getMessage());
            return new TemplatePoint();
        }

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
