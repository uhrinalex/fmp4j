package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;

public record FmpEtfSectorWeighting(FmpSymbol symbol, String sector, Double weightPercentage) implements FmpModel {
    @Serial
    private static final long serialVersionUID = 2L;
}
