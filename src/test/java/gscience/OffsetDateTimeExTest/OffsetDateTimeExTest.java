package gscience.OffsetDateTimeExTest;

import com.gscience.OffsetDateTime.OffsetDateTimeEx;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Unit tests for the OffsetDateTimeEx utility class, focusing on
 * correct conversion from java.sql.Timestamp to UTC OffsetDateTime.
 */
public class OffsetDateTimeExTest {

    private final OffsetDateTimeEx offsetDateTimeEx = new OffsetDateTimeEx();

    /**
     * Tests that the EPOCH constant is correctly defined as 1970-01-01T00:00:00Z.
     */
    @Test
    void testEpochConstant() {
        OffsetDateTime expected = OffsetDateTime.of(1970, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);

        assertEquals(expected, OffsetDateTimeEx.EPOCH,
                "The EPOCH constant should represent the Unix epoch start in UTC.");
        assertEquals(ZoneOffset.UTC, OffsetDateTimeEx.EPOCH.getOffset(),
                "The EPOCH constant must have a UTC (Z) offset.");
    }

    /**
     * Tests a standard conversion of a known Timestamp to its UTC OffsetDateTime equivalent.
     */
    @Test
    void testToUtcOffsetDateTimeConversion() {
        // Arrange a specific point in time
        long millis = 1672531200000L; // Represents 2023-01-01T00:00:00.000Z
        Timestamp inputTimestamp = new Timestamp(millis);

        // Expected result: the same point in time, explicitly offset by UTC (+00:00)
        OffsetDateTime expectedUtc = OffsetDateTime.of(
                2023, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC
        );

        // Act
        OffsetDateTime result = offsetDateTimeEx.toUtcOffsetDateTime(inputTimestamp);

        // Assert
        assertEquals(expectedUtc, result,
                "The converted OffsetDateTime should match the expected UTC instant.");
        assertEquals(ZoneOffset.UTC, result.getOffset(),
                "The resulting OffsetDateTime must always have the ZoneOffset.UTC.");
    }

    /**
     * Tests that the method correctly returns null when a null Timestamp is provided.
     */
    @Test
    void testToUtcOffsetDateTimeNullInput() {
        // Act
        OffsetDateTime result = offsetDateTimeEx.toUtcOffsetDateTime(null);

        // Assert
        assertNull(result, "The method should return null if the input Timestamp is null.");
    }

    /**
     * Tests a Timestamp with sub-second precision to ensure nanos are preserved.
     */
    @Test
    void testToUtcOffsetDateTimeWithNanos() {
        // Arrange
        long millis = 1672531200000L;
        int nanos = 123456789; // Example nanoseconds
        Timestamp inputTimestamp = new Timestamp(millis);
        inputTimestamp.setNanos(nanos);

        // Expected result
        OffsetDateTime expectedUtc = OffsetDateTime.of(
                2023, 1, 1, 0, 0, 0, nanos, ZoneOffset.UTC
        );

        // Act
        OffsetDateTime result = offsetDateTimeEx.toUtcOffsetDateTime(inputTimestamp);

        // Assert
        assertEquals(expectedUtc, result,
                "The conversion must preserve the nanosecond precision.");
    }
}

