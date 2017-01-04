package com.vsu.amm.medframe.entity;

import javax.persistence.*;

@Entity
@Table(name = "MED_TEMPLATE_POINTS")
public class TemplatePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEMPLATE_POINT_ID")
    private Long id;

    @Column(name = "TEMPLATE_ID")
    private Long templateId;

    @Column(name = "INTENSITY_VALUE")
    private Integer intensityValue;

    @Column(name = "FREQUENCY")
    private Integer frequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Integer getInrensityValue() {
        return intensityValue;
    }

    public void setInrensityValue(Integer intensityValue) {
        this.intensityValue = intensityValue;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }
}
