package gscience.offsetDateTime;

import com.gscience.OffsetDateTime.OffsetDateTimeEx;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

public class OffsetDateTimeSpec {


        private OffsetDateTimeEx converter;

        /**
         * Set up the converter instance before each test method.
         */
        @BeforeEach
        void setUp() {
            converter = new OffsetDateTimeEx();
        }

        /**
         * Test case to ensure that a null Timestamp input
         * correctly returns a null OffsetDateTime.
         */
        @Test
        @DisplayName("Should return null for null Timestamp input")
        void shouldReturnNullForNullTimestamp() {
            assertNull(converter.toUtcOffsetDateTime(null),
                    "Converting a null Timestamp should result in a null OffsetDateTime.");
        }

        /**
         * Test case for converting a Timestamp representing a specific UTC instant.
         * We expect the resulting OffsetDateTime to have the same instant and a +00:00 offset.
         */
        @Test
        @DisplayName("Should correctly convert a UTC Timestamp to UTC OffsetDateTime")
        void shouldConvertUtcTimestampToUtcOffsetDateTime() {
            // A known UTC instant
            Instant testInstant = Instant.parse("2023-01-15T10:30:00.123456789Z");
            Timestamp timestamp = Timestamp.from(testInstant);

            OffsetDateTime expectedOdt = OffsetDateTime.ofInstant(testInstant, ZoneOffset.UTC);
            OffsetDateTime actualOdt = converter.toUtcOffsetDateTime(timestamp);

            assertNotNull(actualOdt, "Converted OffsetDateTime should not be null.");
            assertEquals(expectedOdt, actualOdt,
                    "Converted OffsetDateTime should match the expected UTC OffsetDateTime.");
            assertEquals(ZoneOffset.UTC, actualOdt.getOffset(),
                    "The offset of the converted OffsetDateTime should be UTC.");
            assertEquals(testInstant, actualOdt.toInstant(),
                    "The instant of the converted OffsetDateTime should match the original instant.");
        }

        /**
         * Test case for converting a Timestamp representing a local time (e.g., from system default).
         * The underlying instant of the Timestamp should be correctly converted to UTC.
         */
        @Test
        @DisplayName("Should correctly convert local Timestamp (system default) to UTC OffsetDateTime")
        void shouldConvertLocalTimestampToUtcOffsetDateTime() {
            // Create a Timestamp representing a specific local date-time, then convert it to UTC.
            // This is important because Timestamp.toString() uses the default system timezone.
            // Let's pick a date/time where we know the offset from UTC for a typical timezone
            // For example, if system default is "Europe/Brussels" (CEST in summer, CET in winter)
            // Let's choose a summer time, when it's CEST (+02:00)
            long millis = Instant.parse("2025-06-29T21:00:00Z").toEpochMilli() + (2 * 3600 * 1000); // 21:00 UTC = 23:00 CEST
            Timestamp localTimestamp = new Timestamp(millis); // This Timestamp represents 23:00 CEST

            // The expected UTC instant that this localTimestamp *actually* refers to.
            Instant expectedInstant = localTimestamp.toInstant(); // This is the key: Timestamp.toInstant() always gives UTC.

            OffsetDateTime expectedOdt = expectedInstant.atOffset(ZoneOffset.UTC);
            OffsetDateTime actualOdt = converter.toUtcOffsetDateTime(localTimestamp);

            assertNotNull(actualOdt, "Converted OffsetDateTime should not be null for local Timestamp.");
            assertEquals(expectedOdt, actualOdt,
                    "Converted OffsetDateTime for local Timestamp should match expected UTC OffsetDateTime.");
            assertEquals(ZoneOffset.UTC, actualOdt.getOffset(),
                    "The offset of the converted OffsetDateTime from local Timestamp should be UTC.");
            assertEquals(expectedInstant, actualOdt.toInstant(),
                    "The instant of the converted OffsetDateTime from local Timestamp should match the original instant.");
        }

        /**
         * Test case to verify that nanosecond precision is maintained during conversion.
         */
        @Test
        @DisplayName("Should maintain nanosecond precision during conversion")
        void shouldMaintainNanosecondPrecision() {
            // Create a Timestamp with nanosecond precision
            Timestamp timestampWithNanos = Timestamp.from(Instant.parse("2024-05-20T11:22:33.123456789Z"));
            timestampWithNanos.setNanos(123456789); // Ensure nanoseconds are set

            OffsetDateTime actualOdt = converter.toUtcOffsetDateTime(timestampWithNanos);

            assertNotNull(actualOdt, "Converted OffsetDateTime should not be null.");
            assertEquals(timestampWithNanos.toInstant(), actualOdt.toInstant(),
                    "The instant (including nanoseconds) should be preserved during conversion.");
            assertEquals(123456789, actualOdt.getNano(),
                    "Nanosecond value should be correctly transferred.");
        }

}
