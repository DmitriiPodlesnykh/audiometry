package com.vsu.amm.medframe.dto;

public class DevicePointDto {

    private Long id;

    private Long deviceId;

    private int frequency;

    private int intensityLevel;

    private double soundValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
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

    public double getSoundValue() {
        return soundValue;
    }

    public void setSoundValue(double soundLevel) {
        this.soundValue = soundLevel;
    }
}
