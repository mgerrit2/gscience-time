package gscience.datetime;

import com.gscience.datetime.LocalDateTimeEx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class DateTimeExSpec {

    @Test
    void defaultDate() {

        LocalDateTime epoch = LocalDateTimeEx.EPOCH;

        Assertions.assertEquals(epoch,LocalDateTime.of(1970,1,1,0,0,0));
    }
}
