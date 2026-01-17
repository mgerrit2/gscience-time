package com.gscience.dateTime;

import java.time.*;
import java.time.temporal.ChronoField;

public class LocalDateTimeEx {

    /**
     * represent 1970-01-01T00:00:00:00
     */
    public static final LocalDateTime EPOCH = Instant.ofEpochMilli(Instant.EPOCH.toEpochMilli())
            .atZone(ZoneOffset.UTC).toLocalDateTime();


    /**
     * Check if date is a weekend
     * @param ld
     * @return if it is true
     */
    public static boolean isWeekend(final LocalDateTime ld)
    {
        DayOfWeek day = DayOfWeek.of(ld.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }


}
