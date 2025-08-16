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
        System.out.println(Arrays.toString(shortQuotes));
        System.out.println(Arrays.toString(incomeStatements));
        System.out.println(Arrays.toString(balanceSheetStatements));
        System.out.println(Arrays.toString(cashFlowStatements));
    }
}