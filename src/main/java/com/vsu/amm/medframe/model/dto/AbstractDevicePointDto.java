package com.vsu.amm.medframe.model.dto;

public abstract class AbstractDevicePointDto {

    protected int frequency;

    protected int intensityLevel;

    protected double soundValue;

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

    public void setSoundValue(double soundValue) {
        this.soundValue = soundValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractDevicePointDto)) return false;

        AbstractDevicePointDto that = (AbstractDevicePointDto) o;

        if (getFrequency() != that.getFrequency()) return false;
        if (getIntensityLevel() != that.getIntensityLevel()) return false;
        return Double.compare(that.getSoundValue(), getSoundValue()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getFrequency();
        result = 31 * result + getIntensityLevel();
        temp = Double.doubleToLongBits(getSoundValue());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
