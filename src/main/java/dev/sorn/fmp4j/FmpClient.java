package dev.sorn.fmp4j;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatement;
import dev.sorn.fmp4j.models.FmpCashFlowStatement;
import dev.sorn.fmp4j.models.FmpIncomeStatement;
import dev.sorn.fmp4j.models.FmpKeyMetric;
import dev.sorn.fmp4j.models.FmpKeyMetricTtm;
import dev.sorn.fmp4j.models.FmpRatio;
import dev.sorn.fmp4j.models.FmpRatioTtm;
import dev.sorn.fmp4j.models.FmpRevenueGeographicSegmentation;
import dev.sorn.fmp4j.models.FmpRevenueProductSegmentation;
import dev.sorn.fmp4j.models.FmpSearchByIsin;
import dev.sorn.fmp4j.models.FmpSearchByName;
import dev.sorn.fmp4j.models.FmpSearchBySymbol;
import dev.sorn.fmp4j.models.FmpShortQuote;
import dev.sorn.fmp4j.models.FmpStock;
import dev.sorn.fmp4j.services.FmpBalanceSheetStatementService;
import dev.sorn.fmp4j.services.FmpCashFlowStatementService;
import dev.sorn.fmp4j.services.FmpIncomeStatementService;
import dev.sorn.fmp4j.services.FmpKeyMetricService;
import dev.sorn.fmp4j.services.FmpKeyMetricTtmService;
import dev.sorn.fmp4j.services.FmpRatioService;
import dev.sorn.fmp4j.services.FmpRatioTtmService;
import dev.sorn.fmp4j.services.FmpRevenueGeographicSegmentationService;
import dev.sorn.fmp4j.services.FmpRevenueProductSegmentationService;
import dev.sorn.fmp4j.services.FmpSearchByIsinService;
import dev.sorn.fmp4j.services.FmpSearchByNameService;
import dev.sorn.fmp4j.services.FmpSearchBySymbolService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.services.FmpShortQuoteService;
import dev.sorn.fmp4j.services.FmpStockListService;
import java.util.Optional;
import static dev.sorn.fmp4j.cfg.FmpConfigImpl.FMP_CONFIG;
import static dev.sorn.fmp4j.http.FmpHttpClientImpl.FMP_HTTP_CLIENT;

public class FmpClient {
    protected static final int DEFAULT_LIMIT = 5;
    protected final FmpConfig fmpConfig;
    protected final FmpHttpClient fmpHttpClient;

    // Search
    protected final FmpService<FmpSearchByName[]> fmpSearchByNameService;
    protected final FmpService<FmpSearchBySymbol[]> fmpSearchBySymbolService;
    protected final FmpService<FmpSearchByIsin[]> fmpSearchByIsinService;

    // Directory
    protected final FmpService<FmpStock[]> fmpStockListService;

    // Statements
    protected final FmpService<FmpIncomeStatement[]> incomeStatementService;
    protected final FmpService<FmpBalanceSheetStatement[]> balanceSheetStatementService;
    protected final FmpService<FmpCashFlowStatement[]> cashFlowStatementService;
    protected final FmpService<FmpRatio[]> ratioService;
    protected final FmpService<FmpRatioTtm[]> ratioTtmService;
    protected final FmpService<FmpKeyMetric[]> keyMetricService;
    protected final FmpService<FmpKeyMetricTtm[]> keyMetricTtmService;
    protected final FmpService<FmpRevenueGeographicSegmentation[]> revenueGeographicSegmentationService;
    protected final FmpService<FmpRevenueProductSegmentation[]> revenueProductSegmentationService;

    // Quotes
    protected final FmpService<FmpShortQuote[]> shortQuoteService;

    public FmpClient() {
        this(FMP_CONFIG, FMP_HTTP_CLIENT);
    }

    public FmpClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this(
            fmpConfig,
            fmpHttpClient,

            // Search
            new FmpSearchByIsinService(fmpConfig, fmpHttpClient),
            new FmpSearchByNameService(fmpConfig, fmpHttpClient),
            new FmpSearchBySymbolService(fmpConfig, fmpHttpClient),

            // Directory
            new FmpStockListService(fmpConfig, fmpHttpClient),

            // Statements
            new FmpIncomeStatementService(fmpConfig, fmpHttpClient),
            new FmpBalanceSheetStatementService(fmpConfig, fmpHttpClient),
            new FmpCashFlowStatementService(fmpConfig, fmpHttpClient),
            new FmpRatioService(fmpConfig, fmpHttpClient),
            new FmpRatioTtmService(fmpConfig, fmpHttpClient),
            new FmpKeyMetricService(fmpConfig, fmpHttpClient),
            new FmpKeyMetricTtmService(fmpConfig, fmpHttpClient),
            new FmpRevenueGeographicSegmentationService(fmpConfig, fmpHttpClient),
            new FmpRevenueProductSegmentationService(fmpConfig, fmpHttpClient),

            // Quotes
            new FmpShortQuoteService(fmpConfig, fmpHttpClient)
        );
    }

    public FmpClient(
        FmpConfig fmpConfig,
        FmpHttpClient fmpHttpClient,

        // Search
        FmpSearchByIsinService fmpSearchByIsinService,
        FmpSearchByNameService fmpSearchByNameService,
        FmpSearchBySymbolService fmpSearchBySymbolService,

        // Directory
        FmpStockListService fmpStockListService,

        // Statements
        FmpIncomeStatementService incomeStatementService,
        FmpBalanceSheetStatementService balanceSheetStatementService,
        FmpCashFlowStatementService cashFlowStatementService,
        FmpRatioService ratioService,
        FmpRatioTtmService ratioTtmService,
        FmpKeyMetricService keyMetricService,
        FmpKeyMetricTtmService keyMetricTtmService,
        FmpRevenueGeographicSegmentationService revenueGeographicSegmentationService,
        FmpRevenueProductSegmentationService revenueProductSegmentationService,

        // Quotes
        FmpShortQuoteService shortQuoteService
    ) {
        this.fmpConfig = fmpConfig;
        this.fmpHttpClient = fmpHttpClient;

        // Search
        this.fmpSearchByIsinService = fmpSearchByIsinService;
        this.fmpSearchByNameService = fmpSearchByNameService;
        this.fmpSearchBySymbolService = fmpSearchBySymbolService;

        // Directory
        this.fmpStockListService = fmpStockListService;

        // Statements
        this.incomeStatementService = incomeStatementService;
        this.balanceSheetStatementService = balanceSheetStatementService;
        this.cashFlowStatementService = cashFlowStatementService;
        this.ratioService = ratioService;
        this.ratioTtmService = ratioTtmService;
        this.keyMetricService = keyMetricService;
        this.keyMetricTtmService = keyMetricTtmService;
        this.revenueGeographicSegmentationService = revenueGeographicSegmentationService;
        this.revenueProductSegmentationService = revenueProductSegmentationService;

        // Quotes
        this.shortQuoteService = shortQuoteService;
    }

    public synchronized FmpSearchByIsin[] searchByIsin(String isin) {
        fmpSearchByIsinService.param("isin", isin);
        return fmpSearchByIsinService.download();
    }

    public synchronized FmpSearchByName[] searchByName(String query) {
        fmpSearchByNameService.param("query", query);
        return fmpSearchByNameService.download();
    }

    public synchronized FmpSearchBySymbol[] searchBySymbol(String query) {
        fmpSearchBySymbolService.param("query", query);
        return fmpSearchBySymbolService.download();
    }

    public synchronized FmpStock[] stockList() {
        return fmpStockListService.download();
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

    public synchronized FmpRatio[] ratios(String symbol, Optional<String> period, Optional<Integer> limit) {
        ratioService.param("symbol", symbol);
        ratioService.param("period", period.orElse("annual"));
        ratioService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return ratioService.download();
    }

    public synchronized FmpRatioTtm[] ratiosTtm(String symbol) {
        ratioTtmService.param("symbol", symbol);
        return ratioTtmService.download();
    }

    public synchronized FmpKeyMetric[] keyMetrics(String symbol, Optional<String> period, Optional<Integer> limit) {
        keyMetricService.param("symbol", symbol);
        keyMetricService.param("period", period.orElse("annual"));
        keyMetricService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return keyMetricService.download();
    }

    public synchronized FmpKeyMetricTtm[] keyMetricTtm(String symbol) {
        keyMetricTtmService.param("symbol", symbol);
        return keyMetricTtmService.download();
    }

    public synchronized FmpRevenueGeographicSegmentation[] revenueGeographicSegmentations(String symbol, Optional<String> period, Optional<String> structure) {
        revenueGeographicSegmentationService.param("symbol", symbol);
        revenueGeographicSegmentationService.param("period", period.orElse("annual"));
        revenueGeographicSegmentationService.param("structure", structure.orElse("flat"));
        return revenueGeographicSegmentationService.download();
    }

    public synchronized FmpRevenueProductSegmentation[] revenueProductSegmentations(String symbol, Optional<String> period, Optional<String> structure) {
        revenueProductSegmentationService.param("symbol", symbol);
        revenueProductSegmentationService.param("period", period.orElse("annual"));
        revenueProductSegmentationService.param("structure", structure.orElse("flat"));
        return revenueProductSegmentationService.download();
    }

    public synchronized FmpShortQuote[] shortQuotes(String symbol) {
        shortQuoteService.param("symbol", symbol);
        return shortQuoteService.download();
    }
}