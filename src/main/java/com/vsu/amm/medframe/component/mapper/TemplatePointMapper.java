package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.service.TemplateServiceImpl;
import com.vsu.amm.medframe.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemplatePointMapper implements Mapper<TemplatePoint, TemplatePointDto>{

    private static final Logger log = Logger.getLogger(TemplatePointMapper.class);

    @Autowired
    private TemplateServiceImpl templateService;

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
        point.setTemplate(templateService.getOne(pointDto.getTemplateId()));
        return point;
    }
}
