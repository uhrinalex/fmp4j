package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatementGrowth;
import java.util.Set;

public class FmpBalanceSheetStatementGrowthService extends FmpService<FmpBalanceSheetStatementGrowth[]> {
    public FmpBalanceSheetStatementGrowthService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpBalanceSheetStatementGrowth[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/balance-sheet-statement-growth";
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
