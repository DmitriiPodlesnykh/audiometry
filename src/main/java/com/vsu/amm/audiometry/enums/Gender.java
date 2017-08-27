package com.vsu.amm.audiometry.enums;

public enum Gender {
    MALE("Мужской"), FEMALE("Женский");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
