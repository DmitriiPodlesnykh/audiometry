package com.vsu.amm.medframe.model.dto;

import java.util.HashSet;
import java.util.Set;

public class UpdateDeviceRequest extends AbstractDeviceDto{

    private Set<Long> deletedPoint = new HashSet<Long>();

}
