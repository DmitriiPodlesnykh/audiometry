package com.vsu.amm.medframe.service.Impl;


import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.repository.TemplateRepository;
import com.vsu.amm.medframe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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

    @Override
    public Template getOne(Long id) {
        return templateRepository.findOne(id);
    }
}
