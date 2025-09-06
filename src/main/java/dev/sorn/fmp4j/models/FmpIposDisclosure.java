package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpCik;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;
import java.time.LocalDate;

public record FmpIposDisclosure(
        FmpSymbol symbol,
        LocalDate filingDate,
        LocalDate acceptedDate,
        LocalDate effectivenessDate,
        FmpCik cik,
        String form,
        String url)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
