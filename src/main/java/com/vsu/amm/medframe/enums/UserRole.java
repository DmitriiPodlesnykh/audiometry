package com.vsu.amm.medframe.enums;

public enum UserRole {
    USER("Пользователь"),
    ADMIN("Администратор");

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    UserRole(String role) {
        this.role = role;
    }
}
