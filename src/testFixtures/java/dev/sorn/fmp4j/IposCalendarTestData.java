package dev.sorn.fmp4j;

import static dev.sorn.fmp4j.types.FmpSymbol.symbol;

import dev.sorn.fmp4j.models.FmpIposCalendar;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public interface IposCalendarTestData {
    default FmpIposCalendar anIposCalendarRecord() {
        return new FmpIposCalendar(
                symbol("PEVC"),
                LocalDate.parse("2025-02-03"),
                OffsetDateTime.parse("2025-02-03T05:00:00.000Z"),
                "Pacer Funds Trust",
                "NYSE",
                "Expected",
                null,
                null,
                null);
    }
}
