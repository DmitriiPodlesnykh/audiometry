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
    private TemplatePointMapper pointMapper;

    public TemplatePointDto save(TemplatePointDto templatePointDto) {
        TemplatePoint point = pointMapper.mapToEntity(templatePointDto);
        log.info(templatePointDto.toString());
        log.info(point.toString());
        point = templatePointRepository.saveAndFlush(point);
        return pointMapper.mapToDto(point);
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
