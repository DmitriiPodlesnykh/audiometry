package com.vsu.amm.audiometry.service;

import com.vsu.amm.audiometry.model.dto.TemplateDto;

import java.util.List;

public interface TemplateService {

    TemplateDto save(TemplateDto templateDto);

    List<TemplateDto> getAll();

    void delete(Long id);

    TemplateDto getOne(Long id);
}
