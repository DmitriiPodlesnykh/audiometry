package com.vsu.amm.audiometry.model.dto;

public abstract class AbstractDeviceDto {

    private String soundCardName;

    private String headphoneName;

    AbstractDeviceDto() {

    }

    public AbstractDeviceDto(String soundCardName, String headphoneName) {
        this.soundCardName = soundCardName;
        this.headphoneName = headphoneName;
    }

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
