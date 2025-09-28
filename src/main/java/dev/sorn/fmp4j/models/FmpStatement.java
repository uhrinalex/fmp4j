package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpCurrency;
import dev.sorn.fmp4j.types.FmpPeriod;
import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.time.LocalDate;

public interface FmpStatement {
    LocalDate date();

    FmpSymbol symbol();

    FmpCurrency reportedCurrency();

    FmpYear fiscalYear();

    FmpPeriod period();
}
