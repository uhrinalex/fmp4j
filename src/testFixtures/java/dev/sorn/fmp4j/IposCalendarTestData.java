package dev.sorn.fmp4j;

import static dev.sorn.fmp4j.types.FmpSymbol.symbol;

import dev.sorn.fmp4j.models.FmpIposCalendar;
import dev.sorn.fmp4j.types.FmpExchange;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public interface IposCalendarTestData {
    default FmpIposCalendar anIposCalendarRecord() {
        return new FmpIposCalendar(
                symbol("PEVC"),
                LocalDate.parse("2025-02-03"),
                ZonedDateTime.parse("2025-02-03T05:00:00.000Z"),
                "Pacer Funds Trust",
                FmpExchange.NYSE,
                "Expected",
                6818636L,
                "31 - 50.01",
                341000000L);
    }
}
