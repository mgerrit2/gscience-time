package com.gscience.OffsetDateTime;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public class OffsetDateTimeEx {

    public static OffsetDateTimeEx instant = new OffsetDateTimeEx();

    /**
     * represent 1970-01-01T00:00:00Z
     */
    public static final OffsetDateTime EPOCH = Instant.EPOCH.atZone(ZoneOffset.UTC).toOffsetDateTime();

    /**
     * Converts a java.sql.Timestamp to an OffsetDateTime,
     * with the offset explicitly set to UTC (+00:00).
     * This is the recommended approach when Timestamp values are known to represent UTC
     * or when you want a standard, unambiguous UTC representation.
     *
     * @param timestamp The java.sql.Timestamp to convert.
     * @return An OffsetDateTime representing the same instant in time,
     * but with an explicit UTC (+00:00) offset.
     * Returns null if the input timestamp is null.
     */
    public OffsetDateTime toUtcOffsetDateTime(java.sql.Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }
        // Step 1: Convert the Timestamp to an Instant.
        // An Instant represents a point on the time-line, always in UTC.
        Instant instant = timestamp.toInstant();

        // Step 2: Convert the Instant to an OffsetDateTime with a UTC offset.
        // This explicitly states that the time is in UTC.
        return instant.atOffset(ZoneOffset.UTC);
    }


}
