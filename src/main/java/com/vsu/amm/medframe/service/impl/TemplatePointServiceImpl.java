package com.vsu.amm.medframe.service.impl;


import com.vsu.amm.medframe.component.mapper.impl.TemplatePointMapper;
import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.repository.TemplatePointRepository;
import com.vsu.amm.medframe.service.TemplatePointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.*;

@Service
public class TemplatePointServiceImpl implements TemplatePointService{

    private static final Logger LOGGER = Logger.getLogger(TemplatePointServiceImpl.class);

    @Autowired
    private TemplatePointRepository templatePointRepository;

    @Autowired
    private TemplatePointMapper pointMapper;

    @Override
    public TemplatePointDto save(TemplatePointDto templatePointDto) {
        TemplatePoint point = pointMapper.mapToEntity(templatePointDto);
        LOGGER.info(templatePointDto.toString());
        LOGGER.info(point.toString());
        point = templatePointRepository.saveAndFlush(point);
        return pointMapper.mapToDto(point);
    }

    @Override
    public List<TemplatePointDto> getPointsByTemplateId(Long templateId) {
        Set<TemplatePoint> points = new TreeSet<TemplatePoint>(templatePointRepository.findByTemplateId(templateId));
        LOGGER.info(points.toString());
        List<TemplatePointDto> pointDtos = new ArrayList<TemplatePointDto>();
        for (TemplatePoint point : points) {
            TemplatePointDto pointDto = pointMapper.mapToDto(point);
            pointDtos.add(pointDto);
        }
        LOGGER.info(pointDtos.toString());
        return pointDtos;
    }

    @Override
    public TemplatePointDto getPointById(Long pointId){
        TemplatePoint point = templatePointRepository.findOne(pointId);
        TemplatePointDto pointDto = pointMapper.mapToDto(point);
        return pointDto;
    }
}
