package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpCurrency;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;

public record FmpSearchByName(
        FmpSymbol symbol, String name, FmpCurrency currency, String exchangeFullName, String exchange)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 3L;
}
