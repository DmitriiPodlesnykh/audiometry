package com.vsu.amm.audiometry.model.entity;

import com.vsu.amm.audiometry.enums.Frequency;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MED_DEVICE_POINTS")
public class DevicePoint {

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

    public Frequency getFrequency() {
        return Frequency.parse(this.frequency);
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency.getValue();
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
}
