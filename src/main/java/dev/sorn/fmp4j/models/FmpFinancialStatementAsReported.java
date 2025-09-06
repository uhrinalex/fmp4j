package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.io.Serial;
import java.time.LocalDate;
import java.util.Map;

public record FmpFinancialStatementAsReported(
        FmpSymbol symbol,
        FmpYear fiscalYear,
        String period,
        String reportedCurrency,
        LocalDate date,
        Map<String, Number> data)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 3L;
}
