package com.vsu.amm.audiometry.model.dto;

public class CreateDevicePointRequest extends AbstractPointElement implements Comparable{

    private double volumeValue;

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
        return 0;
    }
}
