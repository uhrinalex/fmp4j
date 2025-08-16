package dev.sorn.fmp4j.models;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.math.BigDecimal.TWO;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpShortQuoteTest {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = new FmpShortQuote("AAPL", ONE, TWO, TEN);

        // when
        var after = (FmpShortQuote) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}