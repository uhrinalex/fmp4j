package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;
import java.time.LocalDate;

public record FmpHistoricalPriceEodLight(FmpSymbol symbol, LocalDate date, Double price, Double volume)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
