package com.gscience.datetime;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class InstantEx {

    private InstantEx(){

    }

    /**
     * Returns the current system timestamp formatted as an ISO-8601 string,
     * truncated to second precision (excluding milliseconds and nanoseconds).
     * <p>
     * The resulting string always conforms to the format {@code yyyy-MM-dd'T'HH:mm:ssZ}
     * and is calculated using the UTC (Zulu) timezone.
     * </p>
     * * <p><b>Example Output:</b> {@code 2026-06-11T20:59:08Z}</p>
     *
     * @return a string representation of the current UTC instant with zeroed-out sub-second precision
     */
    public static String nowNoMiliseconds(){
        return Instant.now().truncatedTo(ChronoUnit.SECONDS).toString();
    }

}
