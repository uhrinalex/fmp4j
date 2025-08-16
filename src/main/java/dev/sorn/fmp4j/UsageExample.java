package dev.sorn.fmp4j;

import java.util.Arrays;
import static java.util.Optional.empty;

public class UsageExample {
    public static void main(String[] args) {
        final var fmpClient = new FmpClient();
        final var shortQuotes = fmpClient.shortQuotes("AAPL");
        final var incomeStatements = fmpClient.incomeStatements("AAPL", empty(), empty());
        final var balanceSheetStatements = fmpClient.balanceSheetStatements("AAPL", empty(), empty());
        final var cashFlowStatements = fmpClient.cashFlowStatements("AAPL", empty(), empty());
        final var ratios = fmpClient.ratios("AAPL", empty(), empty());
        final var ratiosTtm = fmpClient.ratiosTtm("AAPL");
        final var keyMetrics = fmpClient.keyMetrics("AAPL", empty(), empty());
        final var keyMetricsTtm = fmpClient.keyMetricTtm("AAPL");
        final var revenueGeographicSegmentations = fmpClient.revenueGeographicSegmentations("AAPL", empty(), empty());
        final var revenueProductSegmentations = fmpClient.revenueProductSegmentations("AAPL", empty(), empty());
        System.out.println(Arrays.toString(shortQuotes));
        System.out.println(Arrays.toString(incomeStatements));
        System.out.println(Arrays.toString(balanceSheetStatements));
        System.out.println(Arrays.toString(cashFlowStatements));
        System.out.println(Arrays.toString(ratios));
        System.out.println(Arrays.toString(ratiosTtm));
        System.out.println(Arrays.toString(keyMetrics));
        System.out.println(Arrays.toString(keyMetricsTtm));
        System.out.println(Arrays.toString(revenueGeographicSegmentations));
        System.out.println(Arrays.toString(revenueProductSegmentations));
    }
}