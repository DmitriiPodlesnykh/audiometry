package com.vsu.amm.medframe.entity;

import javax.persistence.*;
import java.math.BigDecimal;

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

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public BigDecimal getVolumeValue() {
        return volumeValue;
    }

    public void setVolumeValue(BigDecimal volumeValue) {
        this.volumeValue = volumeValue;
    }

    @Override
    public String toString() {
        return "DevicePoint{" +
                "id=" + id +
                ", device=" + device +
                ", intensityLevel=" + intensityLevel +
                ", frequency=" + frequency +
                ", volumeValue=" + volumeValue +
                '}';
    }
}
