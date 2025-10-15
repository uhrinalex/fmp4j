package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;
import static java.util.Collections.emptySet;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpCompany;
import java.util.Set;

public class FmpCompaniesService extends FmpService<FmpCompany[]> {
    public FmpCompaniesService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpCompany[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/profile-bulk";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("part");
    }

    @Override
    protected Set<String> optionalParams() {
        return emptySet();
    }
}
