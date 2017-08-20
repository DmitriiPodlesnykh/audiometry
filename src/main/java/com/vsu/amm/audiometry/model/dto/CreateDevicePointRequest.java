package com.vsu.amm.audiometry.model.dto;

public class CreateDevicePointRequest extends AbstractPointElement implements Comparable{

    private Long deviceId;

    private double volumeValue;

    public CreateDevicePointRequest() {
    }

    public CreateDevicePointRequest(Long deviceId, int frequency, int intensityLevel, double volumeValue) {
        super(frequency, intensityLevel);
        this.deviceId = deviceId;
        this.volumeValue = volumeValue;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public double getVolumeValue() {
        return volumeValue;
    }

    public void setVolumeValue(double volumeValue) {
        this.volumeValue = volumeValue;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "CreateDevicePointRequest{" +
                "deviceId=" + deviceId +
                "frequency=" + frequency +
                ", intensityLevel=" + intensityLevel +
                ", soundValue=" + volumeValue +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int MORE = 1;
        int LESS = -1;
        int EQUAL = 0;

        CreateDevicePointRequest compareObject = (CreateDevicePointRequest) o;
        if (this.intensityLevel > compareObject.getIntensityLevel()) {
            return MORE;
        } else if (this.intensityLevel < compareObject.getIntensityLevel()) {
            return LESS;
        } else if (this.frequency > compareObject.getFrequency()) {
            return MORE;
        } else if (this.frequency < compareObject.getFrequency()) {
            return LESS;
        } else if (this.getVolumeValue() > compareObject.getVolumeValue()) {
            return MORE;
        } else if (this.getVolumeValue() > compareObject.getVolumeValue()) {
            return LESS;
        } else
            return EQUAL;
    }
}
