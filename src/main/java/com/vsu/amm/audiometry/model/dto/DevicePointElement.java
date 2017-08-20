package com.vsu.amm.audiometry.model.dto;

public class DevicePointElement extends AbstractDevicePointDto implements Comparable{

    private Long id;

    private Long deviceId;

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

    public DevicePointElement() {

    }

    public DevicePointElement(int frequency, int intensityLevel, double volumeValue, Long id, Long deviceId) {
        super(frequency, intensityLevel, volumeValue);
        this.id = id;
        this.deviceId = deviceId;
    }
}