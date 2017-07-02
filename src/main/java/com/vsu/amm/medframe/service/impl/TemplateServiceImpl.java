package com.vsu.amm.medframe.service.impl;


import com.vsu.amm.medframe.component.mapper.impl.TemplateMapper;
import com.vsu.amm.medframe.model.dto.TemplateDto;
import com.vsu.amm.medframe.model.entity.Template;
import com.vsu.amm.medframe.repository.TemplateRepository;
import com.vsu.amm.medframe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.log4j.Logger;

@Service
public class TemplateServiceImpl implements TemplateService {

    private static final Logger LOGGER = Logger.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateMapper templateMapper;

    @Autowired
    private TemplateRepository templateRepository;


    @Override
    public TemplateDto save(TemplateDto templateDto) {
        Template template = templateMapper.mapToEntity(templateDto);
        //TODO fix it
        /*if (template.getTemplatePoints() != null && !template.getTemplatePoints().isEmpty()) {
            // TODO to fix it on bulk case
            Set<TemplatePoint> templatePoints = template.getTemplatePoints();
            template.setTemplatePoints(Collections.EMPTY_SET);
            template = templateRepository.saveAndFlush(template);
            for (TemplatePoint point : templatePoints) {
                if (point.getTemplate() == null) {
                    point.setTemplate(template);
                    pointRepository.saveAndFlush(point);
                }
            }
            template.setTemplatePoints(templatePoints);
        }*/
        template = templateRepository.saveAndFlush(template);
        return templateMapper.mapToDto(template);
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
        return convertToListTemplateDtos(templates);
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
