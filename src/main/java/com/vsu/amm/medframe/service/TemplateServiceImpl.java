package com.vsu.amm.medframe.service;


import com.github.jmnarloch.spring.boot.modelmapper.ModelMapperAutoConfiguration;
import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

@Service
public class TemplateServiceImpl {

    private static final Logger log = Logger.getLogger(TemplateServiceImpl.class);

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TemplatePointServiceImpl templatePointService;

    //@Autowired
    //private ModelMapper

    public Template save(TemplateDto templateDto) {

        log.info("RUN Template save(TemplateDto templateDto)");
        log.info("templateDto = " + templateDto.toString());

        Template template = new Template();

        template.setName(templateDto.getName());
        template.setDescription(template.getDescription());
        template.setAuthor(userService.getOne(templateDto.getAuthorId()));
        log.info("Before return template. template = " + template.toString());
        return template;
    }




    public List<TemplateDto> getAll() {
        Template template = templateRepository.findOne(1L);

        TemplateDto templateDto = new TemplateDto();
        templateDto.setName(template.getName());
        templateDto.setId(template.getId());
        templateDto.setAuthorId(template.getAuthor().getId());
        templateDto.setDescription(template.getDescription());

        List<TemplatePoint> templatePoints = template.getTemplatePoints();
        TemplatePoint templatePoint = templatePoints.get(0);

        TemplatePointDto templatePointDto = new TemplatePointDto();
        templatePointDto.setId(templatePoint.getId());
        templatePointDto.setFrequency(templatePoint.getFrequency());
        templatePointDto.setIntensityValue(templatePoint.getInrensityValue());

        log.info(" templatePointDto. attempt to add template id");
        //templatePointDto.setTemplateId(template.getId());
        //templatePointDto.setTemplate(templateDto);
        log.info(" templatePointDto. finished to add template id");

        List<TemplatePointDto> templatePointDtos = new ArrayList<TemplatePointDto>();
        templatePointDtos.add(templatePointDto);
        log.info("templatePointDtos.add(templatePointDto);");
        templateDto.setPoints(templatePointDtos);
        log.info("templateDto.setPoints(templatePointDtos);");


        List<TemplateDto> templateDtos = new ArrayList<TemplateDto>();
        log.info("List<TemplateDto> templateDtos = new ArrayList<TemplateDto>();");
        templateDtos.add(templateDto);

        log.info("templateDto = " + templateDto.toString());
        return templateDtos;
        /*for(Template template : templates){

            //templateDtos.add(modelMapper.map(template, TemplateDto.class));
        }*/
        /*for (Template template : templates) {
            log.info("in for:");
            log.info("template = " + template.toString());
            TemplateDto templateDto = new TemplateDto();
            templateDto.setId(template.getId());
            templateDto.setName(template.getName());
            templateDto.setDescription(template.getDescription());

            //log.info("templateDto = " + templateDto.toString());

            templateDtos.add(templateDto);
        }*/
        //log.info("after for:");
        //log.info("templateDtos = " + templateDtos.toString());

        /*if(templateDtos == null || templateDtos.isEmpty()){
            log.info("templateDto is empty");
            templateDtos = Collections.EMPTY_LIST;
        }

        return templateDtos;*/
    }


    public Template getOne(Long id) {
        return templateRepository.findOne(id);
    }

    public void delete(Long id) {
        templateRepository.delete(id);
    }

    public void methodForTest() {
        log.info("start methodForTest()");
        System.out.println("start methodForTest()");


        Template template = templateRepository.findWithTemplatePointsByIdQ(1L);
        //Template template = templateRepository.findWithTemplatePointsByIdQ(1L);
        System.out.println("template.getName" + template.getName());
        log.info("template.getName" + template.getName());
        System.out.println("template author = " + template.getAuthor().getLastName());
        log.info("finish methodForTest()");
    }
}
