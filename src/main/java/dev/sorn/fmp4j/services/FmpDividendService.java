package dev.sorn.fmp4j.services;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpDividend;
import java.util.Set;
import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

public class FmpDividendService extends FmpService<FmpDividend[]> {
    public FmpDividendService(
        FmpConfig cfg,
        FmpHttpClient http
    ) {
        super(cfg, http, typeRef(FmpDividend[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/dividends";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("symbol");
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of();
    }
}