package com.vsu.amm.medframe.entity;

import javax.persistence.*;

//@Entity
//@Table(name = "MED_DEVICE_INTENSITIES")
public class DeviceIntensity {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "INTENSITY_VALUE_ID")
    private Long id;

    private Device device;

    private int intensityValue;

    private int volumeValue;
}
