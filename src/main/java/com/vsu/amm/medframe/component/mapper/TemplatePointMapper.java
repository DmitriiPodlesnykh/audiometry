package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.TemplatePoint;
import org.springframework.stereotype.Component;

@Component
public class TemplatePointMapper implements Mapper<TemplatePoint, TemplatePointDto>{

    @Override
    public TemplatePointDto mapToDto(TemplatePoint point) {

        TemplatePointDto pointDto = new TemplatePointDto();

        pointDto.setId(point.getId());
        pointDto.setFrequency(point.getFrequency());
        pointDto.setIntensityValue(point.getInrensityValue());
        pointDto.setTemplateId(point.getTemplate().getId());
        return pointDto;
    }

    @Override
    public TemplatePoint mapToEntity(TemplatePointDto pointDto) {
        TemplatePoint point = new TemplatePoint();
        if (pointDto.getId()!=null){
            point.setId(pointDto.getId());
        }
        point.setFrequency(pointDto.getFrequency());
        point.setInrensityValue(pointDto.getIntensityValue());
        return point;
    }
}
