package com.vsu.amm.medframe.model.dto;

import java.util.Set;
import java.util.TreeSet;

public class DeviceResponse extends AbstractDeviceDto{

    private Long id;

    private Set<DevicePointElement> points = new TreeSet<DevicePointElement>();

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
                ", soundCardName='" + soundCardName + '\'' +
                ", headphoneName='" + headphoneName + '\'' +
                ", pointList=" + points.toString() +
                '}';
    }
}
