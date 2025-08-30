package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;
import static java.util.Collections.emptySet;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpTreasuryRate;
import java.util.Set;

public class FmpTreasuryRatesService extends FmpService<FmpTreasuryRate[]> {
    public FmpTreasuryRatesService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpTreasuryRate[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/treasury-rates";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("from", "to");
    }

    @Override
    protected Set<String> optionalParams() {
        return emptySet();
    }
}
