package com.vsu.amm.medframe.service;

import com.vsu.amm.medframe.entity.Template;

import java.util.List;

public interface TemplateService {
    Template save(Template template);
    List<Template> getAll();
    Template getOne(Long id);

}
