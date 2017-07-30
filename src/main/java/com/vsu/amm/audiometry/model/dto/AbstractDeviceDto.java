package com.vsu.amm.audiometry.model.dto;

public abstract class AbstractDeviceDto {

    protected String soundCardName;

    protected String headphoneName;

    public String getSoundCardName() {
        return soundCardName;
    }

    public void setSoundCardName(String soundCardName) {
        this.soundCardName = soundCardName;
    }

    public String getHeadphoneName() {
        return headphoneName;
    }

    public void setHeadphoneName(String headphoneName) {
        this.headphoneName = headphoneName;
    }
}
