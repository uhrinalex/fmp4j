package dev.sorn.fmp4j.models;

import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static dev.sorn.fmp4j.types.FmpSymbol.symbol;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class FmpEarningsCallTranscriptListTest {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = new FmpEarningsCallTranscriptList(symbol("XYZ"), "XYZ Corp.", 42);

        // when
        var after = (FmpEarningsCallTranscriptList) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = new FmpEarningsCallTranscriptList(symbol("XYZ"), "XYZ Corp.", 42);

        // when // then
        verifySerialization(o);
    }
}
