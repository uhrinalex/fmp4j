package dev.sorn.fmp4j;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.*;
import dev.sorn.fmp4j.services.*;

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
    protected final FmpService<FmpSearchByCusip[]> fmpSearchByCusipService;

    // Directory
    protected final FmpService<FmpStock[]> fmpStockListService;
    protected final FmpService<FmpEtf[]> fmpEtfListService;

    // Calendar
    protected final FmpService<FmpDividend[]> fmpDividendService;
    protected final FmpService<FmpDividendsCalendar[]> fmpDividendsCalendarService;
    protected final FmpService<FmpEarning[]> fmpEarningsService;
    protected final FmpService<FmpEarningsCalendar[]> fmpEarningsCalendarService;

    // Chart
    protected final FmpService<FmpHistoricalPriceEodLight[]> fmpHistoricalPriceEodLightService;
    protected final FmpService<FmpHistoricalPriceEodFull[]> fmpHistoricalPriceEodFullService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService1MinService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService5MinService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService15MinService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService30MinService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService1HourService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService4HourService;

    // Company
    protected final FmpService<FmpCompany[]> fmpCompanyService;

    // Statements
    protected final FmpService<FmpIncomeStatement[]> incomeStatementService;
    protected final FmpService<FmpBalanceSheetStatement[]> balanceSheetStatementService;
    protected final FmpService<FmpCashFlowStatement[]> cashFlowStatementService;
    protected final FmpService<FmpRatio[]> ratioService;
    protected final FmpService<FmpRatioTtm[]> ratioTtmService;
    protected final FmpService<FmpKeyMetric[]> keyMetricService;
    protected final FmpService<FmpKeyMetricTtm[]> keyMetricTtmService;
    protected final FmpService<FmpEnterpriseValue[]> enterpriseValuesService;
    protected final FmpService<FmpRevenueGeographicSegmentation[]> revenueGeographicSegmentationService;
    protected final FmpService<FmpRevenueProductSegmentation[]> revenueProductSegmentationService;

    // Quotes
    protected final FmpService<FmpQuote[]> quoteService;
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
            new FmpSearchByCusipService(fmpConfig, fmpHttpClient),

            // Directory
            new FmpStockListService(fmpConfig, fmpHttpClient),
            new FmpEtfListService(fmpConfig, fmpHttpClient),

            // Calendar
            new FmpDividendService(fmpConfig, fmpHttpClient),
            new FmpDividendsCalendarService(fmpConfig, fmpHttpClient),
            new FmpEarningService(fmpConfig, fmpHttpClient),
            new FmpEarningsCalendarService(fmpConfig, fmpHttpClient),

            // Chart
            new FmpHistoricalPriceEodLightService(fmpConfig, fmpHttpClient),
            new FmpHistoricalPriceEodFullService(fmpConfig, fmpHttpClient),
            new FmpHistoricalChartService(fmpConfig, fmpHttpClient, "1min"),
            new FmpHistoricalChartService(fmpConfig, fmpHttpClient, "5min"),
            new FmpHistoricalChartService(fmpConfig, fmpHttpClient, "15min"),
            new FmpHistoricalChartService(fmpConfig, fmpHttpClient, "30min"),
            new FmpHistoricalChartService(fmpConfig, fmpHttpClient, "1hour"),
            new FmpHistoricalChartService(fmpConfig, fmpHttpClient, "4hour"),

            // Company
            new FmpCompanyService(fmpConfig, fmpHttpClient),

            // Statements
            new FmpIncomeStatementService(fmpConfig, fmpHttpClient),
            new FmpBalanceSheetStatementService(fmpConfig, fmpHttpClient),
            new FmpCashFlowStatementService(fmpConfig, fmpHttpClient),
            new FmpRatioService(fmpConfig, fmpHttpClient),
            new FmpRatioTtmService(fmpConfig, fmpHttpClient),
            new FmpKeyMetricService(fmpConfig, fmpHttpClient),
            new FmpKeyMetricTtmService(fmpConfig, fmpHttpClient),
            new FmpEnterpriseValuesService(fmpConfig, fmpHttpClient),
            new FmpRevenueGeographicSegmentationService(fmpConfig, fmpHttpClient),
            new FmpRevenueProductSegmentationService(fmpConfig, fmpHttpClient),

            // Quotes
            new FmpQuoteService(fmpConfig, fmpHttpClient),
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
        FmpSearchByCusipService fmpSearchByCusipService,

        // Directory
        FmpStockListService fmpStockListService,
        FmpEtfListService fmpEtfListService,

        // Calendar
        FmpDividendService fmpDividendService,
        FmpDividendsCalendarService fmpDividendsCalendarService,
        FmpEarningService fmpEarningService,
        FmpEarningsCalendarService fmpEarningsCalendarService,

        // Chart
        FmpHistoricalPriceEodLightService fmpHistoricalPriceEodLightService,
        FmpHistoricalPriceEodFullService fmpHistoricalPriceEodFullService,
        FmpService<FmpHistoricalChart[]> fmpHistoricalChartService1MinService,
        FmpService<FmpHistoricalChart[]> fmpHistoricalChartService5MinService,
        FmpService<FmpHistoricalChart[]> fmpHistoricalChartService15MinService,
        FmpService<FmpHistoricalChart[]> fmpHistoricalChartService30MinService,
        FmpService<FmpHistoricalChart[]> fmpHistoricalChartService1HourService,
        FmpService<FmpHistoricalChart[]> fmpHistoricalChartService4HourService,

        // Company
        FmpCompanyService fmpCompanyService,

        // Statements
        FmpIncomeStatementService incomeStatementService,
        FmpBalanceSheetStatementService balanceSheetStatementService,
        FmpCashFlowStatementService cashFlowStatementService,
        FmpRatioService ratioService,
        FmpRatioTtmService ratioTtmService,
        FmpKeyMetricService keyMetricService,
        FmpKeyMetricTtmService keyMetricTtmService,
        FmpEnterpriseValuesService enterpriseValuesService,
        FmpRevenueGeographicSegmentationService revenueGeographicSegmentationService,
        FmpRevenueProductSegmentationService revenueProductSegmentationService,

        // Quotes
        FmpQuoteService quoteService,
        FmpShortQuoteService shortQuoteService
    ) {
        this.fmpConfig = fmpConfig;
        this.fmpHttpClient = fmpHttpClient;

        // Search
        this.fmpSearchByIsinService = fmpSearchByIsinService;
        this.fmpSearchByNameService = fmpSearchByNameService;
        this.fmpSearchBySymbolService = fmpSearchBySymbolService;
        this.fmpSearchByCusipService = fmpSearchByCusipService;

        // Directory
        this.fmpStockListService = fmpStockListService;
        this.fmpEtfListService = fmpEtfListService;

        // Company
        this.fmpCompanyService = fmpCompanyService;

        // Calendar
        this.fmpDividendService = fmpDividendService;
        this.fmpDividendsCalendarService = fmpDividendsCalendarService;
        this.fmpEarningsService = fmpEarningService;
        this.fmpEarningsCalendarService = fmpEarningsCalendarService;

        // Chart
        this.fmpHistoricalPriceEodLightService = fmpHistoricalPriceEodLightService;
        this.fmpHistoricalPriceEodFullService = fmpHistoricalPriceEodFullService;
        this.fmpHistoricalChartService1MinService = fmpHistoricalChartService1MinService;
        this.fmpHistoricalChartService5MinService = fmpHistoricalChartService5MinService;
        this.fmpHistoricalChartService15MinService = fmpHistoricalChartService15MinService;
        this.fmpHistoricalChartService30MinService = fmpHistoricalChartService30MinService;
        this.fmpHistoricalChartService1HourService = fmpHistoricalChartService1HourService;
        this.fmpHistoricalChartService4HourService = fmpHistoricalChartService4HourService;

        // Statements
        this.incomeStatementService = incomeStatementService;
        this.balanceSheetStatementService = balanceSheetStatementService;
        this.cashFlowStatementService = cashFlowStatementService;
        this.ratioService = ratioService;
        this.ratioTtmService = ratioTtmService;
        this.keyMetricService = keyMetricService;
        this.keyMetricTtmService = keyMetricTtmService;
        this.enterpriseValuesService = enterpriseValuesService;
        this.revenueGeographicSegmentationService = revenueGeographicSegmentationService;
        this.revenueProductSegmentationService = revenueProductSegmentationService;

        // Quotes
        this.quoteService = quoteService;
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

    public synchronized FmpSearchByCusip[] searchByCusip(String cusip) {
        fmpSearchByCusipService.param("cusip", cusip);
        return fmpSearchByCusipService.download();
    }

    public synchronized FmpSearchBySymbol[] searchBySymbol(String query) {
        fmpSearchBySymbolService.param("query", query);
        return fmpSearchBySymbolService.download();
    }

    public synchronized FmpStock[] stockList() {
        return fmpStockListService.download();
    }

    public synchronized FmpEtf[] etfList() {
        return fmpEtfListService.download();
    }

    public synchronized FmpDividendsCalendar[] dividendsCalendar() {
        return fmpDividendsCalendarService.download();
    }

    public synchronized FmpDividend[] dividends(String symbol) {
        fmpDividendService.param("symbol", symbol);
        return fmpDividendService.download();
    }

    public synchronized FmpEarningsCalendar[] earningsCalendar() {
        return fmpEarningsCalendarService.download();
    }

    public synchronized FmpEarning[] earnings(String symbol) {
        fmpEarningsService.param("symbol", symbol);
        return fmpEarningsService.download();
    }

    public synchronized FmpHistoricalPriceEodLight[] historicalPriceEodLight(String symbol, Optional<String> from, Optional<String> to) {
        fmpHistoricalPriceEodLightService.param("symbol", symbol);
        from.ifPresent(date -> fmpHistoricalPriceEodLightService.param("from", date));
        to.ifPresent(date -> fmpHistoricalPriceEodLightService.param("to", date));
        return fmpHistoricalPriceEodLightService.download();
    }

    public synchronized FmpHistoricalPriceEodFull[] historicalPriceEodFull(String symbol, Optional<String> from, Optional<String> to) {
        fmpHistoricalPriceEodFullService.param("symbol", symbol);
        from.ifPresent(date -> fmpHistoricalPriceEodFullService.param("from", date));
        to.ifPresent(date -> fmpHistoricalPriceEodFullService.param("to", date));
        return fmpHistoricalPriceEodFullService.download();
    }

    public synchronized FmpHistoricalChart[] historicalCharts(String interval, String symbol, Optional<String> from, Optional<String> to) {
        return switch (interval) {
            case "1min" -> {
                fmpHistoricalChartService1MinService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService1MinService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService1MinService.param("to", date));
                yield fmpHistoricalChartService1MinService.download();
            }
            case "5min" -> {
                fmpHistoricalChartService5MinService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService5MinService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService5MinService.param("to", date));
                yield fmpHistoricalChartService5MinService.download();
            }
            case "15min" -> {
                fmpHistoricalChartService15MinService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService15MinService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService15MinService.param("to", date));
                yield fmpHistoricalChartService15MinService.download();
            }
            case "30min" -> {
                fmpHistoricalChartService30MinService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService30MinService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService30MinService.param("to", date));
                yield fmpHistoricalChartService30MinService.download();
            }
            case "1hour" -> {
                fmpHistoricalChartService1HourService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService1HourService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService1HourService.param("to", date));
                yield fmpHistoricalChartService1HourService.download();
            }
            case "4hour" -> {
                fmpHistoricalChartService4HourService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService4HourService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService4HourService.param("to", date));
                yield fmpHistoricalChartService4HourService.download();
            }
            default -> throw new IllegalStateException("Unexpected interval: " + interval);
        };
    }

    public synchronized FmpCompany[] company(String symbol) {
        fmpCompanyService.param("symbol", symbol);
        return fmpCompanyService.download();
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

    public synchronized FmpEnterpriseValue[] enterpriseValues(String symbol, Optional<String> period, Optional<Integer> limit) {
        enterpriseValuesService.param("symbol", symbol);
        enterpriseValuesService.param("period", period.orElse("annual"));
        enterpriseValuesService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return enterpriseValuesService.download();
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

    public synchronized FmpQuote[] quotes(String symbol) {
        quoteService.param("symbol", symbol);
        return quoteService.download();
    }

    public synchronized FmpShortQuote[] shortQuotes(String symbol) {
        shortQuoteService.param("symbol", symbol);
        return shortQuoteService.download();
    }
}