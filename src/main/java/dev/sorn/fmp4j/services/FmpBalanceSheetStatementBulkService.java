package dev.sorn.fmp4j.services;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatement;

import java.util.Set;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

public class FmpBalanceSheetStatementBulkService extends FmpService<FmpBalanceSheetStatement[]> {
    public FmpBalanceSheetStatementBulkService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpBalanceSheetStatement[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/balance-sheet-statement-bulk";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("year", "period");
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of();
    }
}
