package com.vsu.amm.medframe.dto;

public class DeviceDto {

    private Long id;

    private String soundCardName;

    private String headphoneName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "DeviceDto{" +
                "id=" + id +
                ", soundCardName='" + soundCardName + '\'' +
                ", headphoneName='" + headphoneName + '\'' +
                '}';
    }
}
