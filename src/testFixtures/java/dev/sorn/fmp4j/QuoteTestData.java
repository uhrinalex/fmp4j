package dev.sorn.fmp4j;

import dev.sorn.fmp4j.models.FmpQuote;
import dev.sorn.fmp4j.models.FmpShortQuote;

public interface QuoteTestData {
    default FmpQuote aQuote() {
        return new FmpQuote(
            "AAPL",
            "Apple Inc.",
            232.8,
            2.1008,
            4.79,
            44489128L,
            226.65,
            233.13,
            260.1,
            164.08,
            3500823120000L,
            240.2278,
            219.98755,
            "NASDAQ",
            227.2,
            228.01,
            1738702801L
        );
    }

    default FmpShortQuote aShortQuote() {
        return new FmpShortQuote(
            "AAPL",
            231.59,
            -1.19,
            54864147L
        );
    }
}