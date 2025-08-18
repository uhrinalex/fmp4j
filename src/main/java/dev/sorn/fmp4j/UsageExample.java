package dev.sorn.fmp4j;

import java.util.Arrays;
import static java.util.Optional.empty;

public class UsageExample {
    public static void main(String[] args) {
        final var fmpClient = new FmpClient();

        // Search
        final var searchByIsinResults = fmpClient.searchByIsin("NL0012969182");
        final var searchByNameResults = fmpClient.searchByName("ADYEN");
        final var searchBySymbolResults = fmpClient.searchBySymbol("ADYEN");

        // Directory
        final var stockList = fmpClient.stockList();
        final var etfList = fmpClient.etfList();

        // Chart
        final var dividends = fmpClient.dividends("AAPL");
        final var dividendsCalendar = fmpClient.dividendsCalendar();
        final var earnings = fmpClient.earnings("AAPL");
        final var earningsCalendar = fmpClient.earningsCalendar();

        // Company
        final var profile = fmpClient.company("AAPL");

        // Statements
        final var incomeStatements = fmpClient.incomeStatements("AAPL", empty(), empty());
        final var balanceSheetStatements = fmpClient.balanceSheetStatements("AAPL", empty(), empty());
        final var cashFlowStatements = fmpClient.cashFlowStatements("AAPL", empty(), empty());
        final var ratios = fmpClient.ratios("AAPL", empty(), empty());
        final var ratiosTtm = fmpClient.ratiosTtm("AAPL");
        final var keyMetrics = fmpClient.keyMetrics("AAPL", empty(), empty());
        final var keyMetricsTtm = fmpClient.keyMetricTtm("AAPL");
        final var revenueGeographicSegmentations = fmpClient.revenueGeographicSegmentations("AAPL", empty(), empty());
        final var revenueProductSegmentations = fmpClient.revenueProductSegmentations("AAPL", empty(), empty());

        // Quotes
        final var shortQuotes = fmpClient.shortQuotes("AAPL");

        // ----

        // Search
        System.out.println(Arrays.toString(searchByIsinResults));
        System.out.println(Arrays.toString(searchByNameResults));
        System.out.println(Arrays.toString(searchBySymbolResults));

        // Directory
        System.out.println(Arrays.toString(stockList));
        System.out.println(Arrays.toString(etfList));

        // Chart
        System.out.println(Arrays.toString(dividends));
        System.out.println(Arrays.toString(dividendsCalendar));
        System.out.println(Arrays.toString(earnings));
        System.out.println(Arrays.toString(earningsCalendar));

        // Company
        System.out.println(Arrays.toString(profile));

        // Statements
        System.out.println(Arrays.toString(incomeStatements));
        System.out.println(Arrays.toString(balanceSheetStatements));
        System.out.println(Arrays.toString(cashFlowStatements));
        System.out.println(Arrays.toString(ratios));
        System.out.println(Arrays.toString(ratiosTtm));
        System.out.println(Arrays.toString(keyMetrics));
        System.out.println(Arrays.toString(keyMetricsTtm));
        System.out.println(Arrays.toString(revenueGeographicSegmentations));
        System.out.println(Arrays.toString(revenueProductSegmentations));

        // Quotes
        System.out.println(Arrays.toString(shortQuotes));
    }
}