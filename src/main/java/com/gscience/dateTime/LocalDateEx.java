package com.gscience.dateTime;

import org.joda.time.DateTimeFieldType;

import java.time.*;
import java.time.temporal.ChronoField;

public class LocalDateEx {

    public static LocalDateEx instant = new LocalDateEx();

    /**
     * represent 1970-01-01T00:00:00
     */
    public static LocalDate EPOCH = Instant.EPOCH.atZone(ZoneOffset.UTC).toLocalDate();


    /**
     * https://stackoverflow.com/questions/64027813/oracle-next-day-function-equivalent-in-java
     * @param value
     * @param day
     * @return
     */
    public LocalDate getNextDay(
            final LocalDate value,
            final DayOfWeek day
    )
    {
        int currentDay = value.getDayOfWeek().getValue();
        int expectedDay = day.getValue();
        if ( currentDay >= expectedDay )
        {
            expectedDay += 7;
        }
        return value.plusDays( expectedDay - currentDay );
    }

    public static boolean isWeekend(final LocalDate ld)
    {
        DayOfWeek day = DayOfWeek.of(ld.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }

}
