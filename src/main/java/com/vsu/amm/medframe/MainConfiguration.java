package com.vsu.amm.medframe;

import com.vsu.amm.medframe.config.SecurityConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringValueResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@EnableAutoConfiguration
@ComponentScan("com.vsu.amm.medframe")
@EnableJpaRepositories
@EnableTransactionManagement
@Import(
        {
                SecurityConfig.class
        }
)
public class MainConfiguration extends WebMvcConfigurerAdapter implements EmbeddedValueResolverAware {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        registry.addResourceHandler("/dataBaseScripts/**").addResourceLocations("classpath:/dataBaseScripts/");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
