package com.vsu.amm.audiometry.enums;

public enum BaseIntensityLevel {

    ZERO_INTENSITY_VALUE(0),
    INTENSITY_LEVEL_10(10),
    INTENSITY_LEVEL_20(20),
    INTENSITY_LEVEL_30(30),
    INTENSITY_LEVEL_40(40),
    INTENSITY_LEVEL_50(50);

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    BaseIntensityLevel(int value) {
        this.value = value;
    }
}
