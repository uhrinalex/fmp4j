package dev.sorn.fmp4j;

import static dev.sorn.fmp4j.types.FmpSymbol.symbol;

import dev.sorn.fmp4j.models.FmpEtf;

public interface EtfTestData {
    default FmpEtf anEtf() {
        return new FmpEtf(symbol("GULF"), "WisdomTree Middle East Dividend Fund");
    }
}
