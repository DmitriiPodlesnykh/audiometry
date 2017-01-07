package com.vsu.amm.medframe.service.Impl;


import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.repository.TemplateRepository;
import com.vsu.amm.medframe.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Template save(TemplateDto templateDto) {
        Template template = new Template();

        template.setName(templateDto.getName());
        template.setDescription(template.getDescription());
        template.setAuthor(userService.getOne(templateDto.getAuthorId()));

        return template;
    }


    @Override
    public List<Template> getAll() {
        return templateRepository.findAll();
    }


    @Override
    public Template getOne(Long id) {
        return templateRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        templateRepository.delete(id);
    }
}
