package com.vsu.amm.medframe.model.dto;

import java.util.ArrayList;
import java.util.List;

public class DeviceDto {

    private Long id;

    private String soundCardName;

    private String headphoneName;

    private List<DevicePointDto> pointList = new ArrayList<DevicePointDto>();

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

    public List<DevicePointDto> getPointList() {
        return pointList;
    }

    public void setPointList(List<DevicePointDto> pointList) {
        this.pointList = pointList;
    }

    @Override
    public String toString() {
        return "DeviceDto{" +
                "id=" + id +
                ", soundCardName='" + soundCardName + '\'' +
                ", headphoneName='" + headphoneName + '\'' +
                ", pointList=" + pointList +
                '}';
    }
}
