package oracle;

import com.gscience.dateTime.LocalDateEx;
import com.gscience.local.LocalEx;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * https://www.oracletutorial.com/oracle-date-functions/oracle-next_day/
 * The Oracle NEXT_DAY() function returns the date of the first weekday specified by day name that is later than a date.
 */
public class NextDayProblemSpec {

    @Test
    void Sunday() {

        LocalDate result = LocalDateEx
                            .instant
                            .getNextDay(LocalDate.of(2022,2,15), DayOfWeek.SUNDAY);

        Assertions.assertEquals(result,LocalDate.of(2022,2,20));

    }


    @Test
    void Saturday() {

        LocalDate result = LocalDateEx
                .instant
                .getNextDay(LocalDate.of(2022,2,15), DayOfWeek.SATURDAY);

        Assertions.assertEquals(result,LocalDate.of(2022,2,19));

    }

}
