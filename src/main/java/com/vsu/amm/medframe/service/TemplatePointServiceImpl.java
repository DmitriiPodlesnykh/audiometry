package com.vsu.amm.medframe.service;


import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplatePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class TemplatePointServiceImpl {

    private static final Logger log = Logger.getLogger(TemplatePointServiceImpl.class);

    @Autowired
    private TemplatePointRepository templatePointRepository;

    @Autowired
    private TemplateServiceImpl templateService;

    public TemplatePoint save(TemplatePointDto templatePointDto) {
        TemplatePoint templatePoint = new TemplatePoint();
        if(templatePointDto.getId() != null){
            templatePoint.setId(templatePointDto.getId());
        }
        templatePoint.setInrensityValue(templatePointDto.getIntensityValue());
        templatePoint.setFrequency(templatePointDto.getFrequency());
        templatePoint.setTemplate(templateService.getOne(templatePointDto.getTemplateId()));
        templatePointRepository.saveAndFlush(templatePoint);
        log.info(templatePoint.toString());
        return templatePoint;
    }

    public Set<TemplatePointDto> getPointForTemplate(Long templateId) {
        templatePointRepository.findByTemplate(templateService.getOne(templateId));
        //convert to dto
        log.info("NPL now");
        return null;
    }


    public Collection<TemplatePoint> getPointByTemplate(Template template) {
        return templatePointRepository.findByTemplate(template);
    }
}
