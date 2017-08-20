package com.vsu.amm.audiometry.model.dto;

public class CreateDevicePointRequest extends AbstractPointElement implements Comparable{

    private double volumeValue;

    public CreateDevicePointRequest() {

    }

    public CreateDevicePointRequest(int frequency, int intensityLevel, double volumeValue) {
        super(frequency, intensityLevel);
        this.volumeValue = volumeValue;
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
