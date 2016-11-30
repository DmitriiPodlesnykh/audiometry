package com.vsu.amm.medframe.entity;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "MED_PATIENTS")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private Date birthday;

    private String sex;

    private Long doctorId;

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
