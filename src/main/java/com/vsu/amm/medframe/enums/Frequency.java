package com.vsu.amm.medframe.enums;

import java.util.ArrayList;
import java.util.List;

public enum Frequency {
    FREQUENCY_40_HZ(40),
    FREQUENCY_100_HZ(100),
    FREQUENCY_250_HZ(250),
    FREQUENCY_1000_HZ(1000),
    FREQUENCY_16000_HZ(16000),
    NULL_VALUE(0);

    private Integer value;

    Frequency(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public static Frequency parse(Integer frequencyValue) {
        Frequency frequency = NULL_VALUE;
        for (Frequency item : Frequency.values()) {
            if (item.getValue().equals(frequencyValue)) {
                frequency = item;
                break;
            }
        }
        return frequency;
    }

    public List<Integer> getAvilableValues() {
        List<Integer> values = new ArrayList();
        for(Frequency item : Frequency.values()) {
            if(!item.equals(NULL_VALUE)) {
                values.add(item.getValue());
            }
        }
        return values;
    }
}
