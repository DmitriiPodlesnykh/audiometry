package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.TemplatePoint;

import java.util.List;

public interface TemplatePointService {
    TemplatePoint save(TemplatePointDto templatePointDto);
    List<TemplatePoint> getPointForTheTemplate(Long templateId);
}
