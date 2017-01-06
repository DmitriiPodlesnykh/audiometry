package com.vsu.amm.medframe.service.Impl;


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

    @Override
    public TemplatePoint save(TemplatePoint templatePoint) {
        return templatePointRepository.save(templatePoint);
    }

    @Override
    public List<TemplatePoint> getPointForTheTemplate(Long templateId) {
        return null;
    }
}
