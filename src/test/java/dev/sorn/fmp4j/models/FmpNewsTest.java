package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.NewsTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpNewsTest implements NewsTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = aStockNews();

        // when
        var after = (FmpNews) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = aStockNews();

        // when // then
        verifySerialization(o);
    }
}