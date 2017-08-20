package com.vsu.amm.audiometry.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MED_DEVICE_POINTS")
public class DevicePoint implements Comparable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEVICE_POINT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEVICE_ID")
    private Device device;

    @Column(name = "INTENSITY_LEVEL")
    private Integer intensityLevel;

    @Column(name = "FREQUENCY")
    private Integer frequency;

    @Column(name = "VOLUME_VALUE")
    private BigDecimal volumeValue;

    @ManyToMany(mappedBy = "devicePoints")
    private List<TestPoint> testPoints = new ArrayList<TestPoint>();

    public DevicePoint() {

    }

    public DevicePoint(Integer intensityLevel, Integer frequency, BigDecimal volumeValue) {
        this.intensityLevel = intensityLevel;
        this.frequency = frequency;
        this.volumeValue = volumeValue;
    }

    public DevicePoint(Device device, Integer intensityLevel, Integer frequency,
                       BigDecimal volumeValue, List<TestPoint> testPoints) {
        this.device = device;
        this.intensityLevel = intensityLevel;
        this.frequency = frequency;
        this.volumeValue = volumeValue;
        this.testPoints = testPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Integer getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(Integer intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

    public BigDecimal getVolumeValue() {
        return volumeValue;
    }

    public void setVolumeValue(BigDecimal volumeValue) {
        this.volumeValue = volumeValue;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public List<TestPoint> getTestPoints() {
        return testPoints;
    }

    public void setTestPoints(List<TestPoint> testPoints) {
        this.testPoints = testPoints;
    }

    @Override
    public String toString() {
        return "DevicePoint{" +
                "id=" + (id != null ? id : 0L) +
                ", deviceId=" + (device != null ? device.getId() : "is empty") +
                ", intensityLevel=" + intensityLevel +
                ", frequency=" + frequency +
                ", volumeValue=" + volumeValue +
                ", testPoints=" + testPoints.toString() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int MORE = 1;
        int LESS = -1;
        int EQUAL = 0;

        DevicePoint devicePoint = (DevicePoint) o;
        if (this.id != null && devicePoint.getId() != null && devicePoint.getId() == this.id) {
            return EQUAL;
        }
        if (this.intensityLevel > devicePoint.getIntensityLevel()) {
            return MORE;
        } else if (this.intensityLevel < devicePoint.getIntensityLevel()) {
            return LESS;
        } else if (this.frequency > devicePoint.getFrequency()) {
            return MORE;
        } else if (this.frequency < devicePoint.getFrequency()) {
            return LESS;
        }
        return EQUAL;
    }
}
