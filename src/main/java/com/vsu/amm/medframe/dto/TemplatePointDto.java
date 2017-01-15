package com.vsu.amm.medframe.dto;

public class TemplatePointDto {

    private Long id;
    private Integer intensityValue;
    private Integer frequency;
    //private Long templateId;

   /* private TemplateDto template;

    public TemplateDto getTemplate() {
        return template;
    }

    public void setTemplate(TemplateDto template) {
        this.template = template;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIntensityValue() {
        return intensityValue;
    }

    public void setIntensityValue(Integer intensityValue) {
        this.intensityValue = intensityValue;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    /*public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }*/

    @Override
    public String toString() {
        return "TemplatePointDto{" +
                "id=" + id +
                ", intensityValue=" + intensityValue +
                ", frequency=" + frequency +
                '}';
    }
}
