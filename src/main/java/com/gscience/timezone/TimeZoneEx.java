package com.gscience.timezone;

import java.util.TimeZone;

public class TimeZoneEx {

    public static TimeZoneEx instant = new TimeZoneEx();

    public TimeZone getUtc(){
       return TimeZone.getTimeZone("UTC");
    }
}
