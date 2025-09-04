package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;
import java.time.LocalDate;
import java.time.OffsetDateTime;

public record FmpIposCalendar(
        FmpSymbol symbol,
        LocalDate date,
        OffsetDateTime daa,
        String company,
        String exchange,
        String actions,
        Double shares,
        Double priceRange,
        Double marketCap)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 1L;
}
