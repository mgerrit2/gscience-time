package com.gscience.vm;

import com.gscience.timezone.TimeZoneEx;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;


import java.util.Locale;
import java.util.TimeZone;

@Log
public class VmEX {

    public static VmEX instant = new VmEX();

    public void setVmTimezone(TimeZone timeZone){
        TimeZone.setDefault(timeZone);
    }

    public void setVmTimezoneToUtc(){
        TimeZone.setDefault(TimeZoneEx.instant.getUtc());
    }

    public void setLocalToUs(){
        Locale.setDefault(new Locale("en", "US"));
    }

    /**
     * print vm settings
     */
    public void  PrintVmSetting(){

        log.info("vm timezone:"+TimeZone.getDefault());
        log.info("vm localsettings:"+Locale.getDefault());
       //System.out.println();
       // System.out.println("vm localsettings:"+Locale.getDefault());
    }
}
