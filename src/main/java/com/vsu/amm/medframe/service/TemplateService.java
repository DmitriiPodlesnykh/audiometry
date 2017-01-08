package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.entity.Template;

import java.util.List;

public interface TemplateService {
    Template save(TemplateDto template);
    List<TemplateDto> getAll();
    Template getOne(Long id);
    void delete(Long id);

}
