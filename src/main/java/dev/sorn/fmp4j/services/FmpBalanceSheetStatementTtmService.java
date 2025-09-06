package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatement;
import java.util.Set;

public class FmpBalanceSheetStatementTtmService extends FmpService<FmpBalanceSheetStatement[]> {
    public FmpBalanceSheetStatementTtmService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpBalanceSheetStatement[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/balance-sheet-statement-ttm";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("symbol");
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of("limit");
    }
}
