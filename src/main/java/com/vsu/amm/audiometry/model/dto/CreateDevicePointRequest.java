package com.vsu.amm.audiometry.model.dto;

public class CreateDevicePointRequest extends AbstractPointElement {

    protected double soundValue;

    public double getSoundValue() {
        return soundValue;
    }

    public void setSoundValue(double soundValue) {
        this.soundValue = soundValue;
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
                ", soundValue=" + soundValue +
                '}';
    }
}
