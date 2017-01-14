package com.vsu.amm.medframe.component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;
import com.vsu.amm.medframe.dto.TemplateDto;
import com.vsu.amm.medframe.entity.Template;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

public class TemplateDtoConverter extends ConverterConfigurerSupport<Template,TemplateDto>{
    @Override
    protected Converter<Template, TemplateDto> converter() {
        return new AbstractConverter<Template, TemplateDto>() {
            @Override
            protected TemplateDto convert(Template template) {
                return null;
            }
        };
    }
}
