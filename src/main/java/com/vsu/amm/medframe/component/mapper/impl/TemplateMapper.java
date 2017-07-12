package com.vsu.amm.medframe.component.mapper.impl;

import com.vsu.amm.medframe.component.mapper.Mapper;
import com.vsu.amm.medframe.model.dto.TemplateDto;
import com.vsu.amm.medframe.model.dto.TemplatePointDto;
import com.vsu.amm.medframe.model.entity.Template;
import com.vsu.amm.medframe.model.entity.TemplatePoint;
import com.vsu.amm.medframe.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

@Component
public class TemplateMapper implements Mapper<Template, TemplateDto> {

    private static final Logger LOGGER = Logger.getLogger(TemplateMapper.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TemplatePointMapper pointMapper;

    @Override
    public TemplateDto mapToDto(Template template) {
        TemplateDto templateDto = new TemplateDto();
        templateDto.setId(template.getId());
        if(template.getAuthor() != null) {
            LOGGER.info("Template was added with out user");
            templateDto.setAuthorId(template.getAuthor().getId());
        }
        templateDto.setName(template.getName());
        templateDto.setDescription(template.getDescription());
        if (template.getTemplatePoints() != null && !template.getTemplatePoints().isEmpty()) {
            Set<TemplatePointDto> pointsDto = new TreeSet();
            for (TemplatePoint point : template.getTemplatePoints()) {
                LOGGER.info(point.toString());
                TemplatePointDto pointDto = pointMapper.mapToDto(point);
                LOGGER.info(pointDto.toString());
                pointsDto.add(pointDto);
            }
            templateDto.setPoints(pointsDto);
        }
        return templateDto;
    }

    @Override
    public Template mapToEntity(TemplateDto templateDto) {
        Template template = new Template();
        if(templateDto.getAuthorId() != null) {
            LOGGER.info("templateDto.getAuthorId() = " + templateDto.getAuthorId());
            template.setAuthor(userService.getUser(templateDto.getId()));
        }
        template.setDescription(templateDto.getDescription());
        template.setName(templateDto.getName());
        if (templateDto.getId() != null) {
            template.setId(templateDto.getId());
        }
        template.setTemplatePoints(toTemplatePoint(templateDto.getPoints()));
        return template;
    }

    private Set<TemplatePoint> toTemplatePoint(Set<TemplatePointDto> pointsDto) {
        if (pointsDto != null && !pointsDto.isEmpty()) {
            Set points = new TreeSet();
            for (TemplatePointDto pointDto : pointsDto) {
                LOGGER.info(pointDto.toString());
                TemplatePoint point = pointMapper.mapToEntity(pointDto);
                points.add(point);
            }
            LOGGER.info(points.toString());
            return points;
        } else {
            return Collections.emptySet();
        }
    }


}
