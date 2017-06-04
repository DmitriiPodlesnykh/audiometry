package com.vsu.amm.medframe.model.dto;

import java.sql.Date;
import java.util.Set;

public class TestDto {

    private Long id;

    private PatientDto patient;

    private TemplateDto template;

    private Date date;

    private Set<TestPointDto> points;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public TemplateDto getTemplate() {
        return template;
    }

    public void setTemplate(TemplateDto template) {
        this.template = template;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<TestPointDto> getPoints() {
        return points;
    }

    public void setPoints(Set<TestPointDto> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "TestDto{" +
                "id=" + (id != null ? id : "is empty") +
                ", patient=" + (patient != null ? patient.getId() : "is empty") +
                ", template=" + (template != null ? template.getId() : "is empty") +
                ", date=" + date +
                ", points=" + (points != null ? points.toString() : "is empty") +
                '}';
    }
}
