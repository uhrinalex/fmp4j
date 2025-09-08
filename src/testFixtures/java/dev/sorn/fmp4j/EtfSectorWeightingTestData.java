package dev.sorn.fmp4j;

import static dev.sorn.fmp4j.types.FmpSector.sector;
import static dev.sorn.fmp4j.types.FmpSymbol.symbol;

import dev.sorn.fmp4j.models.FmpEtfSectorWeighting;

public interface EtfSectorWeightingTestData {
    default FmpEtfSectorWeighting anEtfSectorWeighting() {
        return new FmpEtfSectorWeighting(symbol("SPY"), sector("Utilities"), 2.45);
    }
}
