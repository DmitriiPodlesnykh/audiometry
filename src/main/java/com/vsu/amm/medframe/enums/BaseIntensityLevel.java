package com.vsu.amm.medframe.enums;

public enum BaseIntensityLevel {

    ZERO_INTENSITY_VALUE(0),
    INTENSITY_LEVEL_10(10),
    INTENSITY_LEVEL_20(20),
    INTENSITY_LEVEL_30(30),
    INTENSITY_LEVEL_40(40),
    INTENSITY_LEVEL_50(50),
    INTENSITY_LEVEL_60(60),
    INTENSITY_LEVEL_70(70),
    INTENSITY_LEVEL_80(80),
    INTENSITY_LEVEL_90(90),
    INTENSITY_LEVEL_100(100);

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
