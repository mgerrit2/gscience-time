package com.gscience.time;

public class General {

    public static boolean isLeapTime(int jaar) {
        if (jaar % 4 == 0) {
            if (jaar % 100 == 0) {
                return jaar % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}
