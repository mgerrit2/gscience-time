package gscience;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
;

public class LinuxTimeSpec {

    /**
     * to investigate
     * https://stackoverflow.com/questions/732034/getting-unixtime-in-java
     */
    @Test
    void linuxTime() {

        // 1. Get the system's UTC clock. Using UTC ensures the result is globally standard
        // and unaffected by local time zone settings.
        Clock clock = Clock.systemUTC();

        // 2. Get the current instant using the specified clock.
        Instant currentInstant = Instant.now(clock);

        System.out.println("Current instant Timestamp : " + currentInstant);

        // 3. Extract the Unix epoch seconds from the Instant.
        long unixTime = currentInstant.getEpochSecond();

        // Output the result. This will be visible in the console if testLogging is configured
        // to show standardOut (which your build.gradle file does).
        System.out.println("Current Unix Timestamp (Epoch Seconds): " + unixTime);

        // Optional: Adding an assertion ensures the test remains meaningful.
        // We assert that the timestamp is a positive number (i.e., post-Epoch).
        // Since we cannot assert a specific value, this is a basic sanity check.
        assert(unixTime > 0);

    }
}
