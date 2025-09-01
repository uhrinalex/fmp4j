package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;
import static java.util.Collections.emptySet;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpSearchByCik;
import java.util.Set;

public class FmpSearchByCikService extends FmpService<FmpSearchByCik[]> {
    public FmpSearchByCikService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpSearchByCik[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/search-cik";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("cik");
    }

    @Override
    protected Set<String> optionalParams() {
        return emptySet();
    }
}
