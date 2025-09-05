package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;
import static java.util.Collections.emptySet;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpIposDisclosure;
import java.util.Set;

public class FmpIposDisclosureService extends FmpService<FmpIposDisclosure[]> {
    public FmpIposDisclosureService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpIposDisclosure[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/ipos-disclosure";
    }

    @Override
    protected Set<String> requiredParams() {
        return emptySet();
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of("from", "to");
    }
}
