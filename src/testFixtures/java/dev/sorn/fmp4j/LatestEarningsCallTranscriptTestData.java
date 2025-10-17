package dev.sorn.fmp4j;

import static dev.sorn.fmp4j.types.FmpPeriod.FY;
import static dev.sorn.fmp4j.types.FmpSymbol.symbol;
import static dev.sorn.fmp4j.types.FmpYear.year;

import dev.sorn.fmp4j.models.FmpLatestEarningsCallTranscript;
import java.time.LocalDate;

public interface LatestEarningsCallTranscriptTestData {
    default FmpLatestEarningsCallTranscript aLatestEarningCallTranscript() {
        return new FmpLatestEarningsCallTranscript(LocalDate.parse("2024-09-28"), symbol("GULF"), year("2024"), FY);
    }
}
