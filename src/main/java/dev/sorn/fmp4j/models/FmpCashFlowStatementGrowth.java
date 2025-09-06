package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpPeriod;
import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.io.Serial;
import java.time.LocalDate;

public record FmpCashFlowStatementGrowth(
        FmpSymbol symbol,
        LocalDate date,
        FmpYear fiscalYear,
        FmpPeriod period,
        String reportedCurrency,
        Double growthNetIncome,
        Double growthDepreciationAndAmortization,
        Double growthDeferredIncomeTax,
        Double growthStockBasedCompensation,
        Double growthChangeInWorkingCapital,
        Double growthAccountsReceivables,
        Double growthInventory,
        Double growthAccountsPayables,
        Double growthOtherWorkingCapital,
        Double growthOtherNonCashItems,
        Double growthNetCashProvidedByOperatingActivites,
        Double growthInvestmentsInPropertyPlantAndEquipment,
        Double growthAcquisitionsNet,
        Double growthPurchasesOfInvestments,
        Double growthSalesMaturitiesOfInvestments,
        Double growthOtherInvestingActivites,
        Double growthNetCashUsedForInvestingActivites,
        Double growthDebtRepayment,
        Double growthCommonStockIssued,
        Double growthCommonStockRepurchased,
        Double growthDividendsPaid,
        Double growthOtherFinancingActivites,
        Double growthNetCashUsedProvidedByFinancingActivities,
        Double growthEffectOfForexChangesOnCash,
        Double growthNetChangeInCash,
        Double growthCashAtEndOfPeriod,
        Double growthCashAtBeginningOfPeriod,
        Double growthOperatingCashFlow,
        Double growthCapitalExpenditure,
        Double growthFreeCashFlow,
        Double growthNetDebtIssuance,
        Double growthLongTermNetDebtIssuance,
        Double growthShortTermNetDebtIssuance,
        Double growthNetStockIssuance,
        Double growthPreferredDividendsPaid,
        Double growthIncomeTaxesPaid,
        Double growthInterestPaid)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 1L;
}
