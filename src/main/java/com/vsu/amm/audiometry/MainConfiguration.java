package com.vsu.amm.audiometry;

import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringValueResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableAutoConfiguration
@ComponentScan("com.vsu.amm.audiometry")
@EnableJpaRepositories
@EnableTransactionManagement
@ImportResource("classpath:config.xml")
public class MainConfiguration extends WebMvcConfigurerAdapter implements EmbeddedValueResolverAware {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
