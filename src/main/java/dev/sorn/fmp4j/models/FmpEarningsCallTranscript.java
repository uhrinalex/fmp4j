package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpPeriod;
import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.io.Serial;
import java.time.LocalDate;

public record FmpEarningsCallTranscript(
        FmpSymbol symbol, FmpPeriod period, FmpYear year, LocalDate date, String content) implements FmpModel {
    @Serial
    private static final long serialVersionUID = 1L;
}
