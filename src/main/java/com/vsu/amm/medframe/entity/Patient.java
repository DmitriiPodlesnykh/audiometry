package com.vsu.amm.medframe.entity;


import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "DOCTOR_ID")
    private Long doctorId;

    @Column(name = "DESCRIPTION")
    private String description;

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

    public Date getBirthdate() {
        return birthday;
    }

    public void setBirthdate(Date birthdate) {
        this.birthday = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient() {
    }

    public Patient(Long id, String firstName,
                   String lastName, String middleName,
                   Date birthday, String sex,
                   long doctorId, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.sex = sex;
        this.doctorId = doctorId;
        this.description = description;
    }
}
