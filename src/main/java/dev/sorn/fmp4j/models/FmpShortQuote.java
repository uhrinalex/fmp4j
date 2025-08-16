package dev.sorn.fmp4j.models;

import java.io.Serial;
import java.math.BigDecimal;

public record FmpShortQuote(
    String symbol,
    BigDecimal price,
    BigDecimal change,
    BigDecimal volume
) implements FmpModel {
    @Serial
    private static final long serialVersionUID = 1L;
}