package com.vsu.amm.medframe.service.impl;


import com.vsu.amm.medframe.component.mapper.TemplateMapper;
import com.vsu.amm.medframe.component.mapper.TemplatePointMapper;
import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplateRepository;
import com.vsu.amm.medframe.service.TemplatePointService;
import com.vsu.amm.medframe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.log4j.Logger;

@Service
public class TemplateServiceImpl implements TemplateService {

    private static final Logger log = Logger.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private TemplatePointMapper pointMapper;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private TemplatePointService templatePointService;

    @Override
    public TemplateDto save(TemplateDto templateDto) {
        Template template = templateMapper.mapToEntity(templateDto);
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
            log.info(template.toString());
        }
        TemplateDto newTemplateDto = templateMapper.mapToDto(template);
        log.info(newTemplateDto.toString());
        log.info("template saved");
        return newTemplateDto;
    }

    private List<TemplateDto> convertToListTemplateDtos(List<Template> templates) {
        if (templates == null || templates.isEmpty()) {
            List<TemplateDto> dtos = Collections.EMPTY_LIST;
            return dtos;
        }
        List<TemplateDto> dtos = new ArrayList<TemplateDto>();

        for (Template t : templates) {
            TemplateDto templateDto = templateMapper.mapToDto(t);
            dtos.add(templateDto);
        }
        return dtos;
    }

    @Override
    public List<TemplateDto> getAll() {
        List<Template> templates = templateRepository.findAll();
        List<TemplateDto> templateDtos = convertToListTemplateDtos(templates);

        return templateDtos;
    }

    @Override
    public TemplateDto getOne(Long id) {
        return templateMapper.mapToDto(templateRepository.findOne(id));
    }

    @Override
    public void delete(Long id) {
        templateRepository.delete(id);
    }
}
