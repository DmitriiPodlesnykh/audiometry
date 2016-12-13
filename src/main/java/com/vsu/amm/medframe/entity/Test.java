package com.vsu.amm.medframe.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MED_TESTS")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEST_ID")
    private Long id;

    @Column(name = "PATIENT_ID")
    private Long patientId;

    @Column(name = "TEMPLATE_ID")
    private Long templateId;

    @Column(name = "DATE")
    private Date date;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patient_id) {
        this.patientId = patient_id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long template_id) {
        this.templateId = template_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Test(Long id, Long patientId, Long templateId, Date date) {
        this.id = id;
        this.patientId = patientId;
        this.templateId = templateId;
        this.date = date;
    }

    public Test(){};
}
