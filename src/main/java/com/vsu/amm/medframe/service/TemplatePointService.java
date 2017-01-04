package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.entity.TemplatePoint;

import java.util.List;

public interface TemplatePointService {
    TemplatePoint save(TemplatePoint templatePoint);
    List<TemplatePoint> getPointForTheTemplate(Long templateId);
}
