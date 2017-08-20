package com.vsu.amm.audiometry.model.dto;

import java.util.Set;
import java.util.TreeSet;

public class DeviceResponse extends AbstractDeviceDto{

    private Long id;

    private Set<DevicePointElement> points = new TreeSet<DevicePointElement>();

    public DeviceResponse() {

    }

    public DeviceResponse(String soundCardName, String headphoneName, Long id, Set<DevicePointElement> points) {
        super(soundCardName, headphoneName);
        this.id = id;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<DevicePointElement> getPoints() {
        return points;
    }

    public void setPoints(Set<DevicePointElement> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "DeviceResponse{" +
                "id=" + id +
                ", soundCardName='" + super.getSoundCardName() + '\'' +
                ", headphoneName='" + super.getHeadphoneName() + '\'' +
                ", pointList=" + points.toString() +
                '}';
    }
}
