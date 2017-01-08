package com.vsu.amm.medframe.entity;


import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MED_PATIENTS")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "DOCTOR_ID")
    private User doctor;

    @OneToMany()
    @JoinColumn(name = "PATIENT_ID")
    private List<Test> tests = new ArrayList<Test>();

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User user) {
        this.doctor = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday=" + birthday.toString() +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                ", doctor=" + doctor.toString() +
                ", tests=" + tests.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (id != null ? !id.equals(patient.id) : patient.id != null) return false;
        if (firstName != null ? !firstName.equals(patient.firstName) : patient.firstName != null) return false;
        if (lastName != null ? !lastName.equals(patient.lastName) : patient.lastName != null) return false;
        if (middleName != null ? !middleName.equals(patient.middleName) : patient.middleName != null) return false;
        if (birthday != null ? !birthday.equals(patient.birthday) : patient.birthday != null) return false;
        if (sex != null ? !sex.equals(patient.sex) : patient.sex != null) return false;
        if (description != null ? !description.equals(patient.description) : patient.description != null) return false;
        if (doctor != null ? !doctor.equals(patient.doctor) : patient.doctor != null) return false;
        return tests != null ? tests.equals(patient.tests) : patient.tests == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (tests != null ? tests.hashCode() : 0);
        return result;
    }
}
