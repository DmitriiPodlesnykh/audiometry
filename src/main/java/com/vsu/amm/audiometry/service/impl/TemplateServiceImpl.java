package com.vsu.amm.audiometry.service.impl;

import com.vsu.amm.audiometry.mapper.TemplateMapper;
import com.vsu.amm.audiometry.model.dto.TemplateDto;
import com.vsu.amm.audiometry.model.entity.Template;
import com.vsu.amm.audiometry.repository.TemplateRepository;
import com.vsu.amm.audiometry.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.log4j.Logger;

@Service
public class TemplateServiceImpl implements TemplateService {

    private static final Logger LOGGER = Logger.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateRepository templateRepository;


    @Override
    public TemplateDto save(TemplateDto templateDto) {
        Template template = TemplateMapper.INSTANCE.fromTemplateDto(templateDto);
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
        return TemplateMapper.INSTANCE.toTemplateDto(template);
    }

    private List<TemplateDto> convertToListTemplateDtos(List<Template> templates) {
        if (templates == null || templates.isEmpty()) {
            List<TemplateDto> dtos = Collections.EMPTY_LIST;
            return dtos;
        }
        List<TemplateDto> dtos = new ArrayList<TemplateDto>();

        for (Template t : templates) {
            TemplateDto templateDto = TemplateMapper.INSTANCE.toTemplateDto(t);
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
        return TemplateMapper.INSTANCE.toTemplateDto(templateRepository.findOne(id));
    }

    @Override
    public void delete(Long id) {
        templateRepository.delete(id);
    }
}
