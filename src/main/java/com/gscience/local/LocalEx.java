package com.gscience.local;

import java.time.LocalDate;
import java.time.chrono.*;
import java.time.temporal.TemporalAdjusters;

public class LocalEx {

    public static LocalEx instant = new LocalEx();

    public enum CalendarType {
        GREGORIAN,
        JAPANESE,
        HIJRI
    }

    public LocalDate lastDayOfMonth(LocalDate date, CalendarType calType) {
        Chronology chronology;
        ChronoLocalDate chronoDate;

        switch (calType) {
            case JAPANESE:
                chronology = JapaneseChronology.INSTANCE;
                chronoDate = chronology.date(date);
                break;
            case HIJRI:
                chronology = HijrahChronology.INSTANCE;
                chronoDate = chronology.date(date);
                break;
            case GREGORIAN:
            default:
                chronology = IsoChronology.INSTANCE;
                chronoDate = chronology.date(date);
                break;
        }

        LocalDate isoDate = LocalDate.from(chronoDate);
        return isoDate.with(TemporalAdjusters.lastDayOfMonth());
    }


}
