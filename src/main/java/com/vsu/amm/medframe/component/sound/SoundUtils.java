package com.vsu.amm.medframe.component.sound;

import com.vsu.amm.medframe.dto.DevicePointDto;

class SoundUtils {

    static Double calculateSoundVolume(Integer intensityLevel, DevicePointDto intensityZero) {

        return calculateDeltaVolume(intensityLevel)*intensityZero.getSoundValue();
        //return 0.01;
    }


    private static double calculateDeltaVolume(Integer intensityLevel) {
        return root(2, intensityLevel/10);
    }


    private static double root(double body, double power) {
        return Math.pow(body, 1.0/power);
    }
}
