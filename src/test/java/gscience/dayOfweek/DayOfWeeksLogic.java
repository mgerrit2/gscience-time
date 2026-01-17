package gscience.dayOfweek;

import com.gscience.dateTime.LocalDateEx;
import com.gscience.dateTime.LocalDateTimeEx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class DayOfWeeksLogic {

    @Test
    void isWeekendDayLocalDate() {

        LocalDate someDate = LocalDate.of(2023, 4, 22); // 2nd-Jan-2021

        Assertions.assertTrue( LocalDateEx.isWeekend(someDate));

    }

    @Test
    void isNotWeekendDayLocalDate() {

        LocalDate someDate = LocalDate.of(2023, 4, 21); // 2nd-Jan-2021

        Assertions.assertFalse( LocalDateEx.isWeekend(someDate));

    }

    @Test
    void isNotWeekendDayLocalDateTime() {

        var someDate = LocalDateTime.of(2023, 4, 22,0,0,0); // 2nd-Jan-2021

        Assertions.assertTrue( LocalDateTimeEx.isWeekend(someDate));

    }


}
