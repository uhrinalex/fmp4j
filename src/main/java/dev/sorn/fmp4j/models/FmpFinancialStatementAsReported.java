package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpCurrency;
import dev.sorn.fmp4j.types.FmpPeriod;
import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.io.Serial;
import java.time.LocalDate;
import java.util.Map;

public record FmpFinancialStatementAsReported(
        FmpSymbol symbol,
        FmpYear fiscalYear,
        FmpPeriod period,
        FmpCurrency reportedCurrency,
        LocalDate date,
        Map<String, Number> data)
        implements FmpModel, FmpStatement {
    @Serial
    private static final long serialVersionUID = 4L;
}
