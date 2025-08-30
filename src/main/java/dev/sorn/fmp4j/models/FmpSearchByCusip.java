package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;

public record FmpSearchByCusip(FmpSymbol symbol, String companyName, String cusip, Long marketCap) implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
