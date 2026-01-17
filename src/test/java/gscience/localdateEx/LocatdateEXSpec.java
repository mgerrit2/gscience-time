package gscience.localdateEx;

import com.gscience.local.LocalEx;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LocatdateEXSpec {


    @Test
    void name() {
        var localEx = new LocalEx();

        var lastDateOfMonth = localEx.lastDayOfMonth(LocalDate.now(), LocalEx.CalendarType.GREGORIAN);
    }
}
