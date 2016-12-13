package com.vsu.amm.medframe.entity;

import javax.lang.model.element.Name;
import javax.persistence.*;

@Entity
@Table(name = "MED_TEST_POINTS")
public class TestPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POINT_ID")
    private Long id;

    @Column(name = "TEST_ID")
    private Long testId;

    @Column(name = "FREQUENCY")
    private Integer frequency;

    @Column(name = "INTENSITY_VALUE")
    private Long intensityValue;

    @Column(name = "TEMPLATE_ID")
    private Long templateId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Long getIntensityValue() {
        return intensityValue;
    }

    public void setIntensityValue(Long intensityValue) {
        this.intensityValue = intensityValue;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public TestPoint(Long testId, Integer frequency, Long intensityValue, Long templateId) {
        this.testId = testId;
        this.frequency = frequency;
        this.intensityValue = intensityValue;
        this.templateId = templateId;
    }
}


