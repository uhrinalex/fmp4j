package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.QuoteTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpQuoteTest implements QuoteTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = aQuote();

        // when
        var after = (FmpQuote) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = aQuote();

        // when // then
        verifySerialization(o);
    }
}