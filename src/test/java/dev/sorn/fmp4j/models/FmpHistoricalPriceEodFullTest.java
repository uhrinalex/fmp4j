package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.HistoricalPriceEodTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpHistoricalPriceEodFullTest implements HistoricalPriceEodTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = aHistoricalPriceEodFull();

        // when
        var after = (FmpHistoricalPriceEodFull) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}