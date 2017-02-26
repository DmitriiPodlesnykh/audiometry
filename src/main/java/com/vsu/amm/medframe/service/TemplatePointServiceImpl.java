package com.vsu.amm.medframe.service;


import com.vsu.amm.medframe.component.mapper.TemplatePointMapper;
import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplatePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.*;

@Service
public class TemplatePointServiceImpl {

    private static final Logger log = Logger.getLogger(TemplatePointServiceImpl.class);

    @Autowired
    private TemplatePointRepository templatePointRepository;

    @Autowired
    private TemplateServiceImpl templateService;

    @Autowired
    private TemplatePointMapper pointMapper;

    public TemplatePoint save(TemplatePointDto templatePointDto) {
        TemplatePoint templatePoint = new TemplatePoint();
        if (templatePointDto.getId() != null) {
            templatePoint.setId(templatePointDto.getId());
        }
        templatePoint.setInrensityValue(templatePointDto.getIntensityValue());
        templatePoint.setFrequency(templatePointDto.getFrequency());
        templatePoint.setTemplate(templateService.getOne(templatePointDto.getTemplateId()));
        templatePointRepository.saveAndFlush(templatePoint);
        log.info(templatePoint.toString());
        return templatePoint;
    }

    public List<TemplatePointDto> getPointsByTemplateId(Long templateId) {
        Set<TemplatePoint> points = new TreeSet<TemplatePoint>(templatePointRepository.findByTemplateId(templateId));
        log.info(points.toString());
        List<TemplatePointDto> pointDtos = new ArrayList<TemplatePointDto>();
        for (TemplatePoint point : points) {
            TemplatePointDto pointDto = pointMapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        log.info(pointDtos.toString());
        return pointDtos;
    }

    public TemplatePointDto getPointById(Long pointId){
        TemplatePoint point = templatePointRepository.findOne(pointId);
        TemplatePointDto pointDto = pointMapper.mapToDto(point);
        return pointDto;
    }


    public Collection<TemplatePoint> getPointByTemplate(Template template) {
        return templatePointRepository.findByTemplate(template);
    }
}
