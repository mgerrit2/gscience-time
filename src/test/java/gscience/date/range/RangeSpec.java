package gscience.date.range;

import org.junit.jupiter.api.Test;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class RangeSpec {

    @Test
    void DayToMiniutes() {

        long minutes =
                TimeUnit.MINUTES.convert(60, TimeUnit.DAYS);
    }

    @Test
    void minutesToDays()
    {
        var result = ChronoUnit.DAYS;
    }

}
