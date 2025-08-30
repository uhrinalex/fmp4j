package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;
import java.time.LocalDate;
import java.util.Map;

public record FmpRevenueProductSegmentation(
        FmpSymbol symbol,
        Integer fiscalYear,
        String period,
        String reportedCurrency,
        LocalDate date,
        Map<String, Long> data)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
