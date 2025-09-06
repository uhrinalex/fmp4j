package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public record FmpIposCalendar(
        FmpSymbol symbol,
        LocalDate date,
        ZonedDateTime daa,
        String company,
        String exchange,
        String actions,
        Long shares,
        String priceRange,
        Long marketCap)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
