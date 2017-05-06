package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.dto.TemplateDto;

import java.util.List;

public interface TemplateService {

    TemplateDto save(TemplateDto templateDto);

    List<TemplateDto> getAll();

    void delete(Long id);
}
