package dev.sorn.fmp4j.models;

import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static dev.sorn.fmp4j.types.FmpCik.cik;
import static dev.sorn.fmp4j.types.FmpSymbol.symbol;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class FmpSearchByCikTest {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = new FmpSearchByCik(
                symbol("AAPL"), "Apple Inc.", cik("0000320193"), "NASDAQ Global Select", "NASDAQ", "USD");

        // when
        var after = (FmpSearchByCik) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = new FmpSearchByCik(
                symbol("AAPL"), "Apple Inc.", cik("0000320193"), "NASDAQ Global Select", "NASDAQ", "USD");

        // when // then
        verifySerialization(o);
    }
}
