package com.vsu.amm.medframe.service.Impl;


import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.repository.TemplateRepository;
import com.vsu.amm.medframe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TemplateServiceImpl implements TemplateService{

    @Autowired
    private TemplateRepository templateRepository;

    @Override
    public Template save(Template template) {
        return null;
    }

    @Override
    public List<Template> getAll() {
        return templateRepository.findAll();
    }
}
