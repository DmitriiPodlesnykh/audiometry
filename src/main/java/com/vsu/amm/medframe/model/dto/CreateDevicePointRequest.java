package com.vsu.amm.medframe.model.dto;

public class CreateDevicePointRequest extends AbstractDevicePointDto {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "CreateDevicePointRequest{" +
                "frequency=" + frequency +
                ", intensityLevel=" + intensityLevel +
                ", soundValue=" + soundValue +
                '}';
    }
}
