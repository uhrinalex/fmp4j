package dev.sorn.fmp4j.types;

import java.io.IOException;
import java.util.function.Function;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.types.FmpTicker.TICKER_PATTERN;
import static dev.sorn.fmp4j.types.FmpTicker.ticker;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FmpTickerTest {
    @Test
    void null_ticker_throws() {
        // given
        var value = (String) null;

        // when // then
        var e = assertThrows(NullPointerException.class, () -> ticker(value));
        assertEquals("ticker value is required", e.getMessage());
    }

    @Test
    void trimmed_and_lowercase_are_normalized() {
        // given
        var value = "  aapl ";

        // when
        var ticker = ticker(value);

        // then
        assertEquals("AAPL", ticker.value());
    }

    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = ticker("AAPL");

        // when
        var after = (FmpTicker) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @ParameterizedTest
    @MethodSource("validTickers")
    void valid_tickers(String value) {
        // given // when
        var ticker = ticker(value);

        // then
        assertEquals(value, ticker.value());
    }

    @ParameterizedTest
    @MethodSource("invalidTickers")
    void invalid_tickers(String value) {
        // given // when
        Function<String, FmpTicker> f = FmpTicker::ticker;

        // then
        var e = assertThrows(FmpValueException.class, () -> f.apply(value));
        assertEquals(format("ticker value [%s] does not match pattern [%s]", value.strip(), TICKER_PATTERN.pattern()), e.getMessage());
    }

    private static Stream<String> validTickers() {
        return Stream.of(
            "AAPL",             // NASDAQ
            "BRK.A",            // NYSE
            "TSLA-USD",         // US ETF pair
            "SHOP.TO",          // TSX
            "BHP.AX",           // ASX
            "0005.HK",          // HKEX numeric
            "7203.T",           // TSE numeric
            "S56.SI",           // SGX
            "4F.L",             // LSE
            "MSFT",             // US
            "BF-B",             // NYSE class B
            "HTOOW",            // OTC 5-letter
            "GOGLNE",           // Oslo Børs 6-letter
            "BAC.PR8",          // Preferred share
            "600519.SS",        // Kweichow Moutai (Shanghai)
            "005930.KS",        // Samsung Electronics (KRX)
            "0700.HK",          // Tencent (HKEX)
            "BP.L",             // BP (LSE)
            "SBER.ME",          // Sberbank (MOEX)
            "BTC/USD",          // crypto pair
            "BTC-USD",          // crypto pair
            "ETH-EUR",          // crypto pair
            "NYSE:BRK.A",       // exchange-prefixed
            "A",                // single letter
            "0",                // single digit
            "123456",           // numeric-only
            "ABCDEF",           // 6-letter base
            "ABCDE0",           // mixed 6-char
            "A1B2",             // mixed alphanumeric
            "A1B2.XY",          // valid suffix
            "A1B2.XYZ1"         // valid 4-char suffix
        );
    }

    private static Stream<String> invalidTickers() {
        return Stream.of(
            "",                 // empty string
            " ",                // blank string
            "\t",               // whitespace chars
            "\n",               // whitespace chars
            "\u00A0",           // whitespace chars
            "GOOG!",            // illegal char
            "AAPL#",            // illegal char
            "MSFT@",            // illegal char
            "S56.SI$",          // illegal char
            "4F_L",             // illegal char
            "GOOＧ",            // illegal char (unicode)
            "SBER.ΜE",          // illegal char (unicode)
            "ABCDEFG",          // too long
            "1234567",          // too long numeric
            "NASDAQ:1234567",   // base too long
            "A1B2.XYZ12",       // suffix too long
            "MSFT.",            // suffix missing characters
            "ABC.X!",           // suffix illegal char
            "ABC.1",            // suffix starts with a digit
            "DEF-2A",           // suffix starts with a digit
            ".MSFT",            // leading separator
            "-MSFT",            // leading separator
            "NYSE:",            // missing symbol
            "NYSE:.",           // missing symbol
            "NASDAQ:-TSLA",     // dash after prefix
            "TSLA---USD",       // triple dash
            "TSLA--USD",        // double dash
            "BRK..A",           // double dot
            "LON:BP..L",        // double dot
            "BTC//USD",         // double slash
            "BRK. A",           // internal space
            "TS LA",            // internal space
            "NYSE :BRK.A"       // internal space
        );
    }
}