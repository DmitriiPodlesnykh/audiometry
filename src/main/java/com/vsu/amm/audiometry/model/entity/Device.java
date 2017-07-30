package com.vsu.amm.audiometry.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MED_DEVICES")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEVICE_ID")
    private Long id;

    @Column(name = "SOUND_CARD_NAME")
    private String soundCardName;

    @Column(name = "HEADPHONE_NAME")
    private String headPhoneName;

    @OneToMany(mappedBy = "device")
    private List<DevicePoint> devicePoints = new ArrayList<DevicePoint>();

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
        return headPhoneName;
    }

    public void setHeadphoneName(String headphoneName) {
        this.headPhoneName = headphoneName;
    }

    public List<DevicePoint> getDevicePoints() {
        return devicePoints;
    }

    public void setDevicePoints(List<DevicePoint> devicePoints) {
        this.devicePoints = devicePoints;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + (id != null ? id : 0) +
                ", soundCardName='" + (soundCardName != null ? soundCardName : "is empty") + '\'' +
                ", headphoneName='" + (headPhoneName != null ? headPhoneName : "is empty") + '\'' +
                ", devicePoints=" + (devicePoints != null ? devicePoints : "is empty") +
                '}';
    }
}
