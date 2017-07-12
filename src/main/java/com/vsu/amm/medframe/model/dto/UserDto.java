package com.vsu.amm.medframe.model.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String userType;

    private String email;

    private String password;

    private List<TemplateDto> templates = new ArrayList<TemplateDto>();

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TemplateDto> getTemplates() {
        return templates;
    }

    public void setTemplates(List<TemplateDto> templates) {
        this.templates = templates;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", templates=" + templates +
                '}';
    }
}
