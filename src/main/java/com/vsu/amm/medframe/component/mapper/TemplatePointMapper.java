package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.TemplatePoint;
import org.springframework.stereotype.Component;

@Component
public class TemplatePointMapper implements Mapper<TemplatePoint, TemplatePointDto>{

    @Override
    public TemplatePointDto mapToDto(TemplatePoint templatePoint) {
        return null;
    }

    @Override
    public TemplatePoint mapToEntity(TemplatePointDto pointDto) {
        TemplatePoint point = new TemplatePoint();
        if (pointDto.getId()!=null){
            point.setId(pointDto.getId());
        }
        point.setFrequency(pointDto.getFrequency());
        point.setInrensityValue(pointDto.getIntensityValue());
        //point.setAuthor..
        return point;
    }
}
