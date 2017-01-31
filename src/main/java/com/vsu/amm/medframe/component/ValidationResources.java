package com.vsu.amm.medframe.component;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;
import java.net.URL;

@Component
public class ValidationResources {

    private static final Logger log = Logger.getLogger(ValidationResources.class);

    @PostConstruct
    @Transactional
    public void init() {
        log.info("Start validation resources");
        validFreeMarker("*/header.ftl");
        validFreeMarker("/templates/part/header.ftl");
        validFreeMarker("/templates/template/template.ftl");
        validFreeMarker("*/template.ftl");
        validUltimate("/dataBaseScripts/medDeviceIntensities/CREATE_MED_DEVICE_INTENSITIES.SQL");
        validUltimate("/templates/template/template.ftl");
        log.info("Stop validation resources");
    }

    private void validFreeMarker(String patch) {
        URL url = FreeMarkerConfigurer.class.getClassLoader().getResource(patch);
        if (url != null) {
            log.info("url isnot null");
            log.info(url.toString());
        } else {
            log.info("url==null");
        }
    }

    private void validUltimate(String patch) {
        URL url = getClass().getResource(patch);
        if (url != null) {
            log.info("url isnot null");
            log.info(url.toString());
        } else {
            log.info("url==null");
        }
    }
}
