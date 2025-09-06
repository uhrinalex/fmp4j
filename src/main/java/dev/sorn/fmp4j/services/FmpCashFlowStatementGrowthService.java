package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpCashFlowStatementGrowth;
import java.util.Set;

public class FmpCashFlowStatementGrowthService extends FmpService<FmpCashFlowStatementGrowth[]> {
    public FmpCashFlowStatementGrowthService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpCashFlowStatementGrowth[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/cash-flow-statement-growth";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("symbol");
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of("limit", "period");
    }
}
