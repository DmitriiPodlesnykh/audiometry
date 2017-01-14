package com.vsu.amm.medframe.component;

import com.github.jmnarloch.spring.boot.modelmapper.PropertyMapConfigurerSupport;
import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.entity.Template;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class TemplateDtoMapping extends PropertyMapConfigurerSupport<Template,TemplateDto>{
    @Override
    public PropertyMap<Template, TemplateDto> mapping() {
        return null;
    }
}
