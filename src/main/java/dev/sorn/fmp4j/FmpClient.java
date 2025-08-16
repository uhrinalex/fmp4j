package dev.sorn.fmp4j;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatement;
import dev.sorn.fmp4j.models.FmpCashFlowStatement;
import dev.sorn.fmp4j.models.FmpIncomeStatement;
import dev.sorn.fmp4j.models.FmpShortQuote;
import dev.sorn.fmp4j.services.FmpBalanceSheetStatementService;
import dev.sorn.fmp4j.services.FmpCashFlowStatementService;
import dev.sorn.fmp4j.services.FmpIncomeStatementService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.services.FmpShortQuoteService;
import java.util.Optional;
import static dev.sorn.fmp4j.cfg.FmpConfigImpl.FMP_CONFIG;
import static dev.sorn.fmp4j.http.FmpHttpClientImpl.FMP_HTTP_CLIENT;

public class FmpClient {
    protected static final int DEFAULT_LIMIT = 5;
    protected final FmpConfig fmpConfig;
    protected final FmpHttpClient fmpHttpClient;
    protected final FmpService<FmpShortQuote[]> shortQuoteService;
    protected final FmpService<FmpIncomeStatement[]> incomeStatementService;
    protected final FmpService<FmpBalanceSheetStatement[]> balanceSheetStatementService;
    protected final FmpService<FmpCashFlowStatement[]> cashFlowStatementService;

    public FmpClient() {
        this(
            FMP_CONFIG,
            FMP_HTTP_CLIENT,
            new FmpShortQuoteService(FMP_CONFIG, FMP_HTTP_CLIENT),
            new FmpIncomeStatementService(FMP_CONFIG, FMP_HTTP_CLIENT),
            new FmpBalanceSheetStatementService(FMP_CONFIG, FMP_HTTP_CLIENT),
            new FmpCashFlowStatementService(FMP_CONFIG, FMP_HTTP_CLIENT)
        );
    }

    public FmpClient(
        FmpConfig fmpConfig,
        FmpHttpClient fmpHttpClient,
        FmpShortQuoteService shortQuoteService,
        FmpIncomeStatementService incomeStatementService,
        FmpBalanceSheetStatementService balanceSheetStatementService,
        FmpCashFlowStatementService cashFlowStatementService
    ) {
        this.fmpConfig = fmpConfig;
        this.fmpHttpClient = fmpHttpClient;
        this.shortQuoteService = shortQuoteService;
        this.incomeStatementService = incomeStatementService;
        this.balanceSheetStatementService = balanceSheetStatementService;
        this.cashFlowStatementService = cashFlowStatementService;
    }

    public synchronized FmpShortQuote[] shortQuotes(String symbol) {
        shortQuoteService.param("symbol", symbol);
        return shortQuoteService.download();
    }

    public synchronized FmpIncomeStatement[] incomeStatements(
        String symbol,
        Optional<String> period,
        Optional<Integer> limit
    ) {
        incomeStatementService.param("symbol", symbol);
        incomeStatementService.param("period", period.orElse("annual"));
        incomeStatementService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return incomeStatementService.download();
    }

    public synchronized FmpBalanceSheetStatement[] balanceSheetStatements(
        String symbol,
        Optional<String> period,
        Optional<Integer> limit
    ) {
        balanceSheetStatementService.param("symbol", symbol);
        balanceSheetStatementService.param("period", period.orElse("annual"));
        balanceSheetStatementService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return balanceSheetStatementService.download();
    }

    public synchronized FmpCashFlowStatement[] cashFlowStatements(String symbol, Optional<String> period, Optional<Integer> limit) {
        cashFlowStatementService.param("symbol", symbol);
        cashFlowStatementService.param("period", period.orElse("annual"));
        cashFlowStatementService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return cashFlowStatementService.download();
    }
}