package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpCusip;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;

public record FmpSearchByCusip(FmpSymbol symbol, String companyName, FmpCusip cusip, Long marketCap)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 3L;
}
