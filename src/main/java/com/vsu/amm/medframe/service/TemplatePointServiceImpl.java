package com.vsu.amm.medframe.service;


import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplatePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class TemplatePointServiceImpl {

    @Autowired
    private TemplatePointRepository templatePointRepository;

    @Autowired
    private TemplateServiceImpl templateService;

    public TemplatePoint save(TemplatePointDto templatePointDto) {

        TemplatePoint templatePoint = new TemplatePoint();

        templatePoint.setTemplate(templateService.getOne(templatePointDto.getTemplateId()));
        templatePoint.setInrensityValue(templatePointDto.getIntensityValue());
        templatePoint.setFrequency(templatePointDto.getFrequency());

        return null;
    }

    public List<TemplatePoint> getPointForTheTemplate(Long templateId) {
        return null;
    }


    public Collection<TemplatePoint> getPointByTemplate(Template template) {
        return templatePointRepository.findByTemplate(template);
    }
}
