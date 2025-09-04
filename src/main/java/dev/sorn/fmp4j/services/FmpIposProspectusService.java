package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;
import static java.util.Collections.emptySet;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpIposProspectus;
import java.util.Set;

public class FmpIposProspectusService extends FmpService<FmpIposProspectus[]> {
    public FmpIposProspectusService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpIposProspectus[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/ipos-prospectus";
    }

    @Override
    protected Set<String> requiredParams() {
        return emptySet();
    }

    @Override
    protected Set<String> optionalParams() {
        return emptySet();
    }
}
