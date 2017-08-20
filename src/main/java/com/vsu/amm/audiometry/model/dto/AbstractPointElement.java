package com.vsu.amm.audiometry.model.dto;

public abstract class AbstractPointElement {

    protected int frequency;

    protected int intensityLevel;

    public AbstractPointElement() {
    }

    public AbstractPointElement(int frequency, int intensityLevel) {
        this.frequency = frequency;
        this.intensityLevel = intensityLevel;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(int intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

}
