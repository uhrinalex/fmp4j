package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpEarningsCallTranscript;
import dev.sorn.fmp4j.types.FmpLimit;
import dev.sorn.fmp4j.types.FmpQuarter;
import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.util.Map;

public class FmpEarningsCallTranscriptService extends FmpService<FmpEarningsCallTranscript[]> {
    public FmpEarningsCallTranscriptService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpEarningsCallTranscript[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/earning-call-transcript";
    }

    @Override
    protected Map<String, Class<?>> requiredParams() {
        return Map.of("symbol", FmpSymbol.class, "year", FmpYear.class, "quarter", FmpQuarter.class);
    }

    @Override
    protected Map<String, Class<?>> optionalParams() {
        return Map.of("limit", FmpLimit.class);
    }
}
