package dev.sorn.fmp4j;

import static dev.sorn.fmp4j.types.FmpIsin.isin;
import static dev.sorn.fmp4j.types.FmpSymbol.symbol;

import dev.sorn.fmp4j.models.FmpEtfHolding;
import java.time.LocalDateTime;

public interface EtfHoldingTestData {
    default FmpEtfHolding anEtfHolding() {
        return new FmpEtfHolding(
                symbol("FUSD.L"),
                "DLB",
                "DOLBY LABORATORIES A",
                isin("US25659T1079"),
                "25659T107",
                50906.27973141132,
                0.237,
                3754083.598792928,
                LocalDateTime.parse("2025-08-19T12:08:53"));
    }
}
