package com.vsu.amm.medframe.dto;

public class TemplatePointDto implements Comparable<TemplatePointDto> {

    private Integer intensityValue;

    private Integer frequency;

    public Integer getIntensityValue() {
        return intensityValue;
    }

    public void setIntensityValue(Integer intensityValue) {
        this.intensityValue = intensityValue;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "TemplatePointDto{" +
                " intensityValue=" + intensityValue +
                ", frequency=" + frequency +
                '}';
    }

    @Override
    public int compareTo(TemplatePointDto o) {
        return 0;
    }
}
