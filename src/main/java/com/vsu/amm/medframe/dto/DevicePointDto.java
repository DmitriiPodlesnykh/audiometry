package com.vsu.amm.medframe.dto;

public class DevicePointDto extends AbstractPointDto{

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

    @Override
    public String toString() {
        return "DevicePointDto{" +
                "id=" + (id != null ? id : " is empty") +
                ", deviceId=" + (deviceId != null ?  deviceId : " is empty") +
                ", frequency=" + super.frequency +
                ", intensityLevel=" + super.intensityLevel +
                ", soundValue=" + soundValue +
                '}';
    }
}
