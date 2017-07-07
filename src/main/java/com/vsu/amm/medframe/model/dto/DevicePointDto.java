package com.vsu.amm.medframe.model.dto;

public class DevicePointDto {

    protected Long id;

    protected int frequency;

    protected int intensityLevel;

    private Long deviceId;

    private double soundValue;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public double getSoundValue() {
        return soundValue;
    }

    public void setSoundValue(double soundLevel) {
        this.soundValue = soundLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "DevicePointDto{" +
                "id=" + (id != null ? id : " is empty") +
                ", deviceId=" + (deviceId != null ? deviceId : " is empty") +
                ", frequency=" + frequency +
                ", intensityLevel=" + intensityLevel +
                ", soundValue=" + soundValue +
                '}';
    }
}
