package com.vsu.amm.audiometry.model.dto;

import java.util.HashSet;
import java.util.Set;

public class CreateDeviceRequest extends AbstractDeviceDto {

    private Set<CreateDevicePointRequest> points = new HashSet<CreateDevicePointRequest>();

    public CreateDeviceRequest() {

    }

    public CreateDeviceRequest(String soundCardName, String headphoneName, Set<CreateDevicePointRequest> points) {
        super(soundCardName, headphoneName);
        this.points = points;
    }

    public Set<CreateDevicePointRequest> getPoints() {
        return points;
    }

    public void setPoints(Set<CreateDevicePointRequest> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "CreateDeviceRequest{" +
                "soundCardName='" + super.getSoundCardName() + '\'' +
                ", headphoneName='" + super.getHeadphoneName() + '\'' +
                ", points=" + points.toString() +
                '}';
    }
}