package dev.sorn.fmp4j.clients;

import static dev.sorn.fmp4j.types.FmpLimit.limit;
import static dev.sorn.fmp4j.types.FmpPeriod.ANNUAL;
import static dev.sorn.fmp4j.types.FmpStructure.FLAT;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatement;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatementGrowth;
import dev.sorn.fmp4j.models.FmpCashFlowStatement;
import dev.sorn.fmp4j.models.FmpCashFlowStatementGrowth;
import dev.sorn.fmp4j.models.FmpEnterpriseValue;
import dev.sorn.fmp4j.models.FmpFinancialGrowth;
import dev.sorn.fmp4j.models.FmpFinancialStatementAsReported;
import dev.sorn.fmp4j.models.FmpIncomeStatement;
import dev.sorn.fmp4j.models.FmpIncomeStatementGrowth;
import dev.sorn.fmp4j.models.FmpKeyMetric;
import dev.sorn.fmp4j.models.FmpKeyMetricTtm;
import dev.sorn.fmp4j.models.FmpRatio;
import dev.sorn.fmp4j.models.FmpRatioTtm;
import dev.sorn.fmp4j.models.FmpRevenueGeographicSegmentation;
import dev.sorn.fmp4j.models.FmpRevenueProductSegmentation;
import dev.sorn.fmp4j.services.FmpBalanceSheetStatementGrowthService;
import dev.sorn.fmp4j.services.FmpBalanceSheetStatementService;
import dev.sorn.fmp4j.services.FmpBalanceSheetStatementTtmService;
import dev.sorn.fmp4j.services.FmpCashFlowStatementGrowthService;
import dev.sorn.fmp4j.services.FmpCashFlowStatementService;
import dev.sorn.fmp4j.services.FmpCashFlowStatementTtmService;
import dev.sorn.fmp4j.services.FmpEnterpriseValuesService;
import dev.sorn.fmp4j.services.FmpFinancialGrowthService;
import dev.sorn.fmp4j.services.FmpFinancialStatementAsReportedService;
import dev.sorn.fmp4j.services.FmpIncomeStatementGrowthService;
import dev.sorn.fmp4j.services.FmpIncomeStatementService;
import dev.sorn.fmp4j.services.FmpIncomeStatementTtmService;
import dev.sorn.fmp4j.services.FmpKeyMetricService;
import dev.sorn.fmp4j.services.FmpKeyMetricTtmService;
import dev.sorn.fmp4j.services.FmpRatioService;
import dev.sorn.fmp4j.services.FmpRatioTtmService;
import dev.sorn.fmp4j.services.FmpRevenueGeographicSegmentationService;
import dev.sorn.fmp4j.services.FmpRevenueProductSegmentationService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpLimit;
import dev.sorn.fmp4j.types.FmpPeriod;
import dev.sorn.fmp4j.types.FmpStructure;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.util.Optional;

public class FmpStatementClient {
    protected static final FmpLimit DEFAULT_LIMIT = limit(5);

    protected final FmpService<FmpIncomeStatement[]> incomeStatementService;
    protected final FmpService<FmpBalanceSheetStatement[]> balanceSheetStatementService;
    protected final FmpService<FmpCashFlowStatement[]> cashFlowStatementService;
    protected final FmpService<FmpFinancialStatementAsReported[]> incomeStatementAsReportedService;
    protected final FmpService<FmpFinancialStatementAsReported[]> balanceSheetStatementAsReportedService;
    protected final FmpService<FmpFinancialStatementAsReported[]> cashFlowStatementAsReportedService;
    protected final FmpService<FmpIncomeStatementGrowth[]> incomeStatementGrowthService;
    protected final FmpService<FmpBalanceSheetStatementGrowth[]> balanceSheetStatementGrowthService;
    protected final FmpService<FmpCashFlowStatementGrowth[]> cashFlowStatementGrowthService;
    protected final FmpService<FmpIncomeStatement[]> incomeStatementTtmService;
    protected final FmpService<FmpBalanceSheetStatement[]> balanceSheetStatementTtmService;
    protected final FmpService<FmpCashFlowStatement[]> cashFlowStatementTtmService;
    protected final FmpService<FmpFinancialGrowth[]> financialGrowthService;
    protected final FmpService<FmpRatio[]> ratioService;
    protected final FmpService<FmpRatioTtm[]> ratioTtmService;
    protected final FmpService<FmpKeyMetric[]> keyMetricService;
    protected final FmpService<FmpKeyMetricTtm[]> keyMetricTtmService;
    protected final FmpService<FmpEnterpriseValue[]> enterpriseValuesService;
    protected final FmpService<FmpRevenueGeographicSegmentation[]> revenueGeographicSegmentationService;
    protected final FmpService<FmpRevenueProductSegmentation[]> revenueProductSegmentationService;

    public FmpStatementClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.incomeStatementService = new FmpIncomeStatementService(fmpConfig, fmpHttpClient);
        this.balanceSheetStatementService = new FmpBalanceSheetStatementService(fmpConfig, fmpHttpClient);
        this.cashFlowStatementService = new FmpCashFlowStatementService(fmpConfig, fmpHttpClient);
        this.incomeStatementAsReportedService =
                new FmpFinancialStatementAsReportedService(fmpConfig, fmpHttpClient, "income");
        this.balanceSheetStatementAsReportedService =
                new FmpFinancialStatementAsReportedService(fmpConfig, fmpHttpClient, "balance-sheet");
        this.cashFlowStatementAsReportedService =
                new FmpFinancialStatementAsReportedService(fmpConfig, fmpHttpClient, "cash-flow");
        this.incomeStatementTtmService = new FmpIncomeStatementTtmService(fmpConfig, fmpHttpClient);
        this.balanceSheetStatementTtmService = new FmpBalanceSheetStatementTtmService(fmpConfig, fmpHttpClient);
        this.cashFlowStatementTtmService = new FmpCashFlowStatementTtmService(fmpConfig, fmpHttpClient);
        this.incomeStatementGrowthService = new FmpIncomeStatementGrowthService(fmpConfig, fmpHttpClient);
        this.balanceSheetStatementGrowthService = new FmpBalanceSheetStatementGrowthService(fmpConfig, fmpHttpClient);
        this.cashFlowStatementGrowthService = new FmpCashFlowStatementGrowthService(fmpConfig, fmpHttpClient);
        this.financialGrowthService = new FmpFinancialGrowthService(fmpConfig, fmpHttpClient);
        this.ratioService = new FmpRatioService(fmpConfig, fmpHttpClient);
        this.ratioTtmService = new FmpRatioTtmService(fmpConfig, fmpHttpClient);
        this.keyMetricService = new FmpKeyMetricService(fmpConfig, fmpHttpClient);
        this.keyMetricTtmService = new FmpKeyMetricTtmService(fmpConfig, fmpHttpClient);
        this.enterpriseValuesService = new FmpEnterpriseValuesService(fmpConfig, fmpHttpClient);
        this.revenueGeographicSegmentationService =
                new FmpRevenueGeographicSegmentationService(fmpConfig, fmpHttpClient);
        this.revenueProductSegmentationService = new FmpRevenueProductSegmentationService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpIncomeStatement[] income(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        incomeStatementService.param("symbol", symbol);
        incomeStatementService.param("period", period.orElse(ANNUAL));
        incomeStatementService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return incomeStatementService.download();
    }

    public synchronized FmpFinancialStatementAsReported[] incomeAsReported(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        incomeStatementAsReportedService.param("symbol", symbol);
        incomeStatementAsReportedService.param("period", period.orElse(ANNUAL));
        incomeStatementAsReportedService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return incomeStatementAsReportedService.download();
    }

    public synchronized FmpIncomeStatementGrowth[] incomeGrowth(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        incomeStatementGrowthService.param("symbol", symbol);
        incomeStatementGrowthService.param("period", period.orElse(ANNUAL));
        incomeStatementGrowthService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return incomeStatementGrowthService.download();
    }

    public synchronized FmpIncomeStatement[] incomeTtm(FmpSymbol symbol, Optional<FmpLimit> limit) {
        incomeStatementTtmService.param("symbol", symbol);
        incomeStatementTtmService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return incomeStatementTtmService.download();
    }

    public synchronized FmpBalanceSheetStatement[] balanceSheet(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        balanceSheetStatementService.param("symbol", symbol);
        balanceSheetStatementService.param("period", period.orElse(ANNUAL));
        balanceSheetStatementService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return balanceSheetStatementService.download();
    }

    public synchronized FmpFinancialStatementAsReported[] balanceSheetAsReported(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        balanceSheetStatementAsReportedService.param("symbol", symbol);
        balanceSheetStatementAsReportedService.param("period", period.orElse(ANNUAL));
        balanceSheetStatementAsReportedService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return balanceSheetStatementAsReportedService.download();
    }

    public synchronized FmpBalanceSheetStatementGrowth[] balanceSheetGrowth(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        balanceSheetStatementGrowthService.param("symbol", symbol);
        balanceSheetStatementGrowthService.param("period", period.orElse(ANNUAL));
        balanceSheetStatementGrowthService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return balanceSheetStatementGrowthService.download();
    }

    public synchronized FmpBalanceSheetStatement[] balanceSheetTtm(FmpSymbol symbol, Optional<FmpLimit> limit) {
        balanceSheetStatementTtmService.param("symbol", symbol);
        balanceSheetStatementTtmService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return balanceSheetStatementTtmService.download();
    }

    public synchronized FmpCashFlowStatement[] cashFlow(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        cashFlowStatementService.param("symbol", symbol);
        cashFlowStatementService.param("period", period.orElse(ANNUAL));
        cashFlowStatementService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return cashFlowStatementService.download();
    }

    public synchronized FmpFinancialStatementAsReported[] cashFlowAsReported(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        cashFlowStatementAsReportedService.param("symbol", symbol);
        cashFlowStatementAsReportedService.param("period", period.orElse(ANNUAL));
        cashFlowStatementAsReportedService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return cashFlowStatementAsReportedService.download();
    }

    public synchronized FmpCashFlowStatementGrowth[] cashFlowGrowth(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        cashFlowStatementGrowthService.param("symbol", symbol);
        cashFlowStatementGrowthService.param("period", period.orElse(ANNUAL));
        cashFlowStatementGrowthService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return cashFlowStatementGrowthService.download();
    }

    public synchronized FmpCashFlowStatement[] cashFlowTtm(FmpSymbol symbol, Optional<FmpLimit> limit) {
        cashFlowStatementTtmService.param("symbol", symbol);
        cashFlowStatementTtmService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return cashFlowStatementTtmService.download();
    }

    public synchronized FmpFinancialGrowth[] financialGrowth(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        financialGrowthService.param("symbol", symbol);
        financialGrowthService.param("period", period.orElse(ANNUAL));
        financialGrowthService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return financialGrowthService.download();
    }

    public synchronized FmpKeyMetric[] keyMetrics(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        keyMetricService.param("symbol", symbol);
        keyMetricService.param("period", period.orElse(ANNUAL));
        keyMetricService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return keyMetricService.download();
    }

    public synchronized FmpKeyMetricTtm[] keyMetricsTtm(FmpSymbol symbol) {
        keyMetricTtmService.param("symbol", symbol);
        return keyMetricTtmService.download();
    }

    public synchronized FmpRatio[] ratios(FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        ratioService.param("symbol", symbol);
        ratioService.param("period", period.orElse(ANNUAL));
        ratioService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return ratioService.download();
    }

    public synchronized FmpRatioTtm[] ratiosTtm(FmpSymbol symbol) {
        ratioTtmService.param("symbol", symbol);
        return ratioTtmService.download();
    }

    public synchronized FmpEnterpriseValue[] enterpriseValues(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpLimit> limit) {
        enterpriseValuesService.param("symbol", symbol);
        enterpriseValuesService.param("period", period.orElse(ANNUAL));
        enterpriseValuesService.param("limit", limit.orElse(DEFAULT_LIMIT));
        return enterpriseValuesService.download();
    }

    public synchronized FmpRevenueGeographicSegmentation[] revenueGeographicSegmentations(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpStructure> structure) {
        revenueGeographicSegmentationService.param("symbol", symbol);
        revenueGeographicSegmentationService.param("period", period.orElse(ANNUAL));
        revenueGeographicSegmentationService.param("structure", structure.orElse(FLAT));
        return revenueGeographicSegmentationService.download();
    }

    public synchronized FmpRevenueProductSegmentation[] revenueProductSegmentations(
            FmpSymbol symbol, Optional<FmpPeriod> period, Optional<FmpStructure> structure) {
        revenueProductSegmentationService.param("symbol", symbol);
        revenueProductSegmentationService.param("period", period.orElse(ANNUAL));
        revenueProductSegmentationService.param("structure", structure.orElse(FLAT));
        return revenueProductSegmentationService.download();
    }
}
