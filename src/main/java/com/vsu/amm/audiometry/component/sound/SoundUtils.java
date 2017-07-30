package com.vsu.amm.audiometry.component.sound;

import com.vsu.amm.audiometry.model.dto.DevicePointElement;
import com.vsu.amm.audiometry.enums.BaseIntensityLevel;
import org.apache.log4j.Logger;

import static java.lang.Math.pow;

class SoundUtils {

    private static final Logger log = Logger.getLogger(SoundUtils.class);

    public static double createAmplitudeValue(BaseIntensityLevel intensityLevel, double amplitudeAtZeroIntensityLevel) {
        log.info("createAmplitudeValue: intensityLevel = " + intensityLevel.getValue() +
                "; amplitudeAtZeroIntensityLevel = " + amplitudeAtZeroIntensityLevel);
        double ratio = getRatio(intensityLevel);
        log.info("current amplitude value =  amplitudeAtZeroIntensityLevel*ratio = " +amplitudeAtZeroIntensityLevel*ratio);
        return amplitudeAtZeroIntensityLevel*ratio;
    }


    private static double getRatio(BaseIntensityLevel intensityLevel) {
        log.info("  intensityLevel.getValue() = " + intensityLevel.getValue());
        log.info("      intensityLevel.getValue()/20) = " + (double)intensityLevel.getValue()/20);
        double result = pow(10, (double)intensityLevel.getValue()/20);
        log.info("          pow(10, intensityLevel.getValue()/20) = " +result);
        return result;
    }

    //private static double

    static Double calculateSoundVolume(Integer intensityLevel, DevicePointElement intensityZero) {

        return calculateDeltaVolume(intensityLevel)*intensityZero.getSoundValue();
        //return 0.01;
    }


    private static double calculateDeltaVolume(Integer intensityLevel) {
        return root(2, intensityLevel/10);
    }


    private static double root(double body, double power) {
        return pow(body, 1.0/power);
    }
}
