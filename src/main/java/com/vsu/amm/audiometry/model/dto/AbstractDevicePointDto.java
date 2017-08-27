package com.vsu.amm.audiometry.model.dto;

public class AbstractDevicePointDto extends AbstractPointElement implements Comparable{

    protected double volumeValue;

    public AbstractDevicePointDto(){

    }

    public AbstractDevicePointDto(int frequency, int intensityLevel, double volumeValue) {
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
    public String toString() {
        return "AbstractDevicePointDto{" +
                "volumeValue=" + volumeValue +
                ", frequency=" + frequency +
                ", intensityLevel=" + intensityLevel +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int MORE = 1;
        int LESS = -1;
        int EQUAL = 0;

        AbstractDevicePointDto point = (AbstractDevicePointDto) o;

        if(this.intensityLevel > point.getIntensityLevel()) {
            return MORE;
        } else if(this.intensityLevel < point.getIntensityLevel()) {
            return LESS;
        } else if(this.frequency > point.getFrequency()) {
            return MORE;
        } else if(this.frequency < point.getFrequency()) {
            return LESS;
        }

        return EQUAL;
    }
}
