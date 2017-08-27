package com.vsu.amm.audiometry.model.dto;

import java.util.Collection;
import java.util.TreeSet;

public class CreateTestRequest {

    private Long templateId;

    private Long patientId;

    private Long userId;

    private Collection<TestPointResponse> testPoints = new TreeSet<TestPointResponse>();

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

    public Collection<TestPointResponse> getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(Collection<TestPointResponse> testPoins) {
        this.testPoints = testPoins;
    }
}
