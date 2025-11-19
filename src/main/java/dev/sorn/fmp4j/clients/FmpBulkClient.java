package dev.sorn.fmp4j.clients;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatement;
import dev.sorn.fmp4j.models.FmpCompanies;
import dev.sorn.fmp4j.services.FmpBalanceSheetStatementBulkService;
import dev.sorn.fmp4j.services.FmpCompaniesService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpPart;
import dev.sorn.fmp4j.types.FmpPeriod;
import dev.sorn.fmp4j.types.FmpYear;

public class FmpBulkClient {

    // Alphabetical order
    protected final FmpService<FmpCompanies[]> fmpByPartService;
    protected final FmpService<FmpBalanceSheetStatement[]> balanceSheetStatementBulkService;

    public FmpBulkClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpByPartService = new FmpCompaniesService(fmpConfig, fmpHttpClient);
        this.balanceSheetStatementBulkService = new FmpBalanceSheetStatementBulkService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpCompanies[] byPart(FmpPart part) {
        fmpByPartService.param("part", part);
        return fmpByPartService.download();
    }

    public synchronized FmpBalanceSheetStatement[] balanceSheetStatements(FmpYear year, FmpPeriod period) {
        balanceSheetStatementBulkService.param("year", year);
        balanceSheetStatementBulkService.param("period", period);

        return balanceSheetStatementBulkService.download();
    }
}
