package com.vsu.amm.medframe.dto;

public class TemplatePointDto implements Comparable<TemplatePointDto> {

    private Long id;

    private Integer intensityValue;

    private Integer frequency;

    private Long templateId;

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
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

    @Override
    public String toString() {
        return "TemplatePointDto{" +
                "id=" + id +
                ", intensityValue=" + intensityValue +
                ", frequency=" + frequency +
                ", templateId=" + templateId +
                '}';
    }

    @Override
    public int compareTo(TemplatePointDto o) {
        return 0;
    }
}
