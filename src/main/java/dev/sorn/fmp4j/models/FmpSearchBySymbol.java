package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;

public record FmpSearchBySymbol(
        FmpSymbol symbol, String name, String currency, String exchangeFullName, String exchange) implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
