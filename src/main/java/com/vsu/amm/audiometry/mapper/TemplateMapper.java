package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.dto.TemplateDto;
import com.vsu.amm.audiometry.model.entity.Template;
import com.vsu.amm.audiometry.model.entity.TemplateFrequency;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
        TemplateFrequencyMapper.class
})
public interface TemplateMapper {

    TemplateMapper INSTANCE = Mappers.getMapper(TemplateMapper.class);

    @Mapping(source = "frequencies", target = "frequencies")
    TemplateDto toTemplateDto(Template entity);

    @InheritInverseConfiguration
    Template fromTemplateDto(TemplateDto dto);
}
