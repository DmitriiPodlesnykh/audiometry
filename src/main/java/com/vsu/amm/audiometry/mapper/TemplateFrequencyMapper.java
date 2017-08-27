package com.vsu.amm.audiometry.mapper;

import com.vsu.amm.audiometry.model.entity.TemplateFrequency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TemplateFrequencyMapper {

    default Integer fromTemplateFrequency(TemplateFrequency entity) {
        return entity.getValue();
    }

    @Mapping(target = "value")
    TemplateFrequency toTemplateFrequency(Integer integer);
}
