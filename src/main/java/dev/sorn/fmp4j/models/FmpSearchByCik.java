package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpCik;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;

public record FmpSearchByCik(
        FmpSymbol symbol, String companyName, FmpCik cik, String exchangeFullName, String exchange, String currency)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
