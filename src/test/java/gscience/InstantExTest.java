package gscience;

import com.gscience.datetime.InstantEx;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class InstantExTest {

    // Regex pattern to match exactly: yyyy-MM-ddTHH:mm:ssZ
    private static final Pattern ISO_NO_MILLIS_PATTERN =
            Pattern.compile("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z$");

    @Test
    @DisplayName("Should return string matching exact ISO-8601 second-precision format")
    void shouldReturnCorrectFormat() {
        String result = InstantEx.nowNoMiliseconds();

        assertNotNull(result, "The returned timestamp should not be null");
        assertTrue(ISO_NO_MILLIS_PATTERN.matcher(result).matches(),
                "The format must match 'yyyy-MM-ddTHH:mm:ssZ' exactly. Received: " + result);
    }

    @Test
    @DisplayName("Should exclude millisecond dot or sub-second values entirely")
    void shouldNotContainMilliseconds() {
        String result = InstantEx.nowNoMiliseconds();

        // If milliseconds exist, a decimal dot separator (e.g., .000Z or .123Z) appears
        assertFalse(result.contains("."),
                "The timestamp should not contain a decimal point for fractions of a second");
    }

    @Test
    @DisplayName("Should be valid parsable standard ISO-8601 Instant")
    void shouldBeParsableAsInstant() {
        String result = InstantEx.nowNoMiliseconds();

        // If it isn't compliant with ISO-8601, Instant.parse will throw DateTimeParseException
        assertDoesNotThrow(() -> Instant.parse(result),
                "The generated string must be natively parsable back into a java.time.Instant");
    }

    @Test
    @DisplayName("Should represent a time very close to the current actual execution time")
    void shouldBeCloseToCurrentTime() {
        Instant systemBefore = Instant.now();
        String resultStr = InstantEx.nowNoMiliseconds();
        Instant systemAfter = Instant.now();

        Instant resultInstant = Instant.parse(resultStr);

        // Account for truncation: strip millis from before/after benchmarks for a fair comparison
        long beforeEpochSecond = systemBefore.getEpochSecond();
        long afterEpochSecond = systemAfter.getEpochSecond();
        long resultEpochSecond = resultInstant.getEpochSecond();

        // The generated second must fall within the execution window (usually identical, tolerance of 1s max)
        assertTrue(resultEpochSecond >= beforeEpochSecond && resultEpochSecond <= afterEpochSecond,
                String.format("Result second (%d) was outside execution window [%d - %d]",
                        resultEpochSecond, beforeEpochSecond, afterEpochSecond));
    }
}