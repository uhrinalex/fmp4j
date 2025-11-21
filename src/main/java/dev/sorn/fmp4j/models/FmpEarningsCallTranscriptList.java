package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;

public record FmpEarningsCallTranscriptList(FmpSymbol symbol, String companyName, Integer noOfTranscripts)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 1L;
}
