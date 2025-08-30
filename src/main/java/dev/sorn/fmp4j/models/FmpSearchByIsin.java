package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;

public record FmpSearchByIsin(FmpSymbol symbol, String name, String isin, Long marketCap) implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
