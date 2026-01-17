package gscience;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.TimeZone;

/**
 * https://jenkov.com/tutorials/java-date-time/java-util-timezone.html
 * https://stackoverflow.com/questions/43837323/how-do-i-make-java-sql-timestamp-utc-time
 */
public class TimeStampAndInstantSpec {

    @Test
    void brusselTime() {


        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Brussels"));

        var resultSqlTimeStamp = Timestamp.from(Instant.now());

        var resultInstant = resultSqlTimeStamp.toInstant();

    }

    @Test
    void utcTime() {


        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        var resultSqlTimeStamp = Timestamp.from(Instant.now());

        var resultInstant = resultSqlTimeStamp.toInstant();

    }

    @Test
    void michiganTime() {


        TimeZone.setDefault(TimeZone.getTimeZone("US/Michigan"));

        var resultSqlTimeStamp = Timestamp.from(Instant.now());

        var resultInstant = resultSqlTimeStamp.toInstant();

    }

    @Test
    void InstantUTCTime() {


        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Brussels"));



        var resultInstant = Instant.now();

    }

}
