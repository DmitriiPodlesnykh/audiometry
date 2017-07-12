package com.vsu.amm.medframe.model.dto;

import java.util.Collection;
import java.util.TreeSet;

public class CreateTestDto {

    private Long testId;

    private Long templateId;

    private Long patientId;

    private Long userId;

    private Collection<TestPointDto> testPoints = new TreeSet<TestPointDto>();

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Collection<TestPointDto> getTestPoins() {
        return testPoints;
    }

    public void setTestPoins(Collection<TestPointDto> testPoins) {
        this.testPoints = testPoins;
    }
}
