package com.vsu.amm.audiometry.model.dto;

public class DevicePointResponse extends AbstractDevicePointDto implements Comparable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DevicePointResponse() {

    }

    public DevicePointResponse(int frequency, int intensityLevel, double volumeValue, Long id) {
        super(frequency, intensityLevel, volumeValue);
        this.id = id;
    }

    @Override
    public String toString() {
        return "DevicePointResponse{" +
                "id=" + id +
                ", volumeValue=" + volumeValue +
                ", frequency=" + frequency +
                ", intensityLevel=" + intensityLevel +
                '}';
    }

}
