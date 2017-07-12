package com.vsu.amm.medframe.component.mapper.impl;

import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.model.dto.TemplatePointDto;
import com.vsu.amm.medframe.model.entity.TemplatePoint;
import com.vsu.amm.medframe.service.TemplateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemplatePointMapper implements Mapper<TemplatePoint, TemplatePointDto> {

    private static final Logger LOGGER = Logger.getLogger(TemplatePointMapper.class);

    @Autowired
    private TemplateService templateService;

    @Override
    public TemplatePointDto mapToDto(TemplatePoint point) {
        TemplatePointDto pointDto = new TemplatePointDto();

        pointDto.setId(point.getId());
        pointDto.setFrequency(point.getFrequency());
        pointDto.setIntensityLevel(point.getInrensityValue());
        if(point.getTemplate() != null) {
            pointDto.setTemplateId(point.getTemplate().getId());
        }
        return pointDto;
    }

    @Override
    public TemplatePoint mapToEntity(TemplatePointDto pointDto) {
        TemplatePoint point = new TemplatePoint();
        if (pointDto.getId()!=null){
            point.setId(pointDto.getId());
        }
        point.setFrequency(pointDto.getFrequency());
        point.setInrensityValue(pointDto.getIntensityLevel());
        //point.setTemplate(templateService.getOne(pointDto.getTemplateId()));
        return point;
    }
}
