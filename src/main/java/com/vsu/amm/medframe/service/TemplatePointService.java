package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.dto.TemplatePointDto;

import java.util.List;

public interface TemplatePointService {

    TemplatePointDto save(TemplatePointDto templatePoint);

    List<TemplatePointDto> getPointsByTemplateId(Long templateId);

    TemplatePointDto getPointById(Long pointId);
}
