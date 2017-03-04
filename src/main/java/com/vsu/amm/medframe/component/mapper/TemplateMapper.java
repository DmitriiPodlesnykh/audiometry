package com.vsu.amm.medframe.component.mapper;

import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.dto.TemplatePointDto;
import com.vsu.amm.medframe.entity.Template;
import com.vsu.amm.medframe.entity.TemplatePoint;
import com.vsu.amm.medframe.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

@Component
public class TemplateMapper implements Mapper<Template, TemplateDto> {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TemplatePointMapper pointMapper;

    @Override
    public TemplateDto mapToDto(Template template) {
        TemplateDto templateDto = new TemplateDto();
        templateDto.setId(template.getId());
        templateDto.setAuthorId(template.getAuthor().getId());
        templateDto.setName(template.getName());
        templateDto.setDescription(template.getDescription());
        if (template.getTemplatePoints() != null && !template.getTemplatePoints().isEmpty()) {
            Set<TemplatePointDto> pointsDto = new TreeSet();
            for (TemplatePoint point : template.getTemplatePoints()) {
                TemplatePointDto pointDto = pointMapper.mapToDto(point);
                pointsDto.add(pointDto);
            }
            templateDto.setPoints(pointsDto);
        }
        return templateDto;
    }

    @Override
    public Template mapToEntity(TemplateDto templateDto) {
        Template template = new Template();
        template.setAuthor(userService.getUser(templateDto.getId()));
        template.setDescription(templateDto.getDescription());
        template.setName(templateDto.getName());
        if (templateDto.getId() != null) {
            template.setId(templateDto.getId());
        }
        template.setTemplatePoints(toTemplatePoint(templateDto.getPoints()));
        return template;
    }

    private Set<TemplatePoint> toTemplatePoint(Set<TemplatePointDto> pointsDto) {
        if (pointsDto != null && pointsDto.isEmpty()) {
            Set points = new TreeSet();
            for (TemplatePointDto pointDto : pointsDto) {
                TemplatePoint point = pointMapper.mapToEntity(pointDto);
                points.add(point);
            }
            return points;
        } else {
            return Collections.emptySet();
        }
    }
}
