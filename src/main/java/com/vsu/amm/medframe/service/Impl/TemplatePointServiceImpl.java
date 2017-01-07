package com.vsu.amm.medframe.service.Impl;


import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplatePointRepository;
import com.vsu.amm.medframe.service.TemplatePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TemplatePointServiceImpl implements TemplatePointService{

    @Autowired
    private TemplatePointRepository templatePointRepository;

    @Autowired
    private TemplateServiceImpl templateService;

    @Override
    public TemplatePoint save(TemplatePointDto templatePointDto) {

        TemplatePoint templatePoint = new TemplatePoint();

        templatePoint.setTemplate(templateService.getOne(templatePointDto.getTemplateId()));
        templatePoint.setInrensityValue(templatePointDto.getIntensityValue());
        templatePoint.setFrequency(templatePointDto.getFrequency());

        return null;
    }

    @Override
    public List<TemplatePoint> getPointForTheTemplate(Long templateId) {
        return null;
    }
}
