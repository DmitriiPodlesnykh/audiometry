package com.vsu.amm.medframe.entity;

import javax.persistence.*;

//@Entity
//@Table(name = "MED_DEVICE")
public class Device {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "DEVICE_ID")
    private Long id;

    //@Column(name = "SOUND_CARD_NAME")
    private String soundCardName;

    //@Column(name = "HEADPHONE_NAME")
    private String headphoneNsme;

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

    public String getHeadphoneNsme() {
        return headphoneNsme;
    }

    public void setHeadphoneNsme(String headphoneNsme) {
        this.headphoneNsme = headphoneNsme;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", soundCardName='" + soundCardName + '\'' +
                ", headphoneNsme='" + headphoneNsme + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Device device = (Device) o;

        if (id != null ? !id.equals(device.id) : device.id != null) return false;
        if (soundCardName != null ? !soundCardName.equals(device.soundCardName) : device.soundCardName != null)
            return false;
        return headphoneNsme != null ? headphoneNsme.equals(device.headphoneNsme) : device.headphoneNsme == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (soundCardName != null ? soundCardName.hashCode() : 0);
        result = 31 * result + (headphoneNsme != null ? headphoneNsme.hashCode() : 0);
        return result;
    }
}
