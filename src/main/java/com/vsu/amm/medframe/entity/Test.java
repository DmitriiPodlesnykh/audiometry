package com.vsu.amm.medframe.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "MED_TESTS")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEST_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "TEMPLATE_ID")
    private Template template;

    @Column(name = "DATE")
    private Date date;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test")
    private Set<TestPoint> testPoints = new TreeSet<TestPoint>();

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

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Set<TestPoint> getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(Set<TestPoint> testPoints) {
        this.testPoints = testPoints;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + (id != null ? id : "is empty") +
                ", patient=" + (patient != null ? patient.toString() : "is empty") +
                ", template=" + (template != null ? template.toString() : "is empty") +
                ", date=" + date +
                ", testPoints=" + (testPoints != null ? testPoints.toString() : "is empty") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != null ? !id.equals(test.id) : test.id != null) return false;
        if (patient != null ? !patient.equals(test.patient) : test.patient != null) return false;
        if (template != null ? !template.equals(test.template) : test.template != null) return false;
        if (date != null ? !date.equals(test.date) : test.date != null) return false;
        return testPoints != null ? testPoints.equals(test.testPoints) : test.testPoints == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (template != null ? template.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (testPoints != null ? testPoints.hashCode() : 0);
        return result;
    }
}
