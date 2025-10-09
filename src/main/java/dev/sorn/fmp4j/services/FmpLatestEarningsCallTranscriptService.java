package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpLatestEarningsCallTranscript;
import java.util.Set;

public class FmpLatestEarningsCallTranscriptService extends FmpService<FmpLatestEarningsCallTranscript[]> {
    public FmpLatestEarningsCallTranscriptService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpLatestEarningsCallTranscript[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/earning-call-transcript-latest";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("limit");
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of("page");
    }
}
