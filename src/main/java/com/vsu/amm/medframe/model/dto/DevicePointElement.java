package com.vsu.amm.medframe.model.dto;

public class DevicePointElement extends AbstractPointElement implements Comparable{

    private Long id;

    private Long deviceId;

    private double soundValue;

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSoundValue() {
        return soundValue;
    }

    public void setSoundValue(double soundValue) {
        this.soundValue = soundValue;
    }

    @Override
    public String toString() {
        return "DevicePointElement{" +
                "frequency=" + frequency +
                ", id=" + id +
                ", intensityLevel=" + intensityLevel +
                ", deviceId=" + deviceId +
                ", soundValue=" + soundValue +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int MORE = 1;
        int LESS = -1;
        int EQUAL = 0;

        DevicePointElement response = (DevicePointElement) o;

        if(this.id.equals(response.deviceId)) {
            return EQUAL;
        }

        if (!this.deviceId.equals(response.deviceId)) {
            return LESS;
        }

        if(this.intensityLevel > response.intensityLevel
                && this.soundValue > response.soundValue) {
            return MORE;
        } else if(this.intensityLevel < response.intensityLevel
                && this.soundValue < response.soundValue) {
            return LESS;
        } else if(this.intensityLevel == response.intensityLevel) {
            return EQUAL;
        }

        return MORE;
    }
}