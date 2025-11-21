package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpEarningsCallTranscriptList;
import java.util.Map;

public class FmpEarningsCallTranscriptListService extends FmpService<FmpEarningsCallTranscriptList[]> {
    public FmpEarningsCallTranscriptListService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpEarningsCallTranscriptList[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/earnings-transcript-list";
    }

    @Override
    protected Map<String, Class<?>> requiredParams() {
        return Map.of();
    }

    @Override
    protected Map<String, Class<?>> optionalParams() {
        return Map.of();
    }
}
