package dev.sorn.fmp4j.models;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpSearchByNameTest {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = new FmpSearchByName("AAPL", "Apple Inc.", "USD", "NASDAQ Global Select", "NASDAQ");

        // when
        var after = (FmpSearchByName) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}