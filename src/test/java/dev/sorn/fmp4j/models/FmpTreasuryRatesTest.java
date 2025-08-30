package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.TreasuryRatesTestData;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpTreasuryRatesTest implements TreasuryRatesTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = aFmpTreasuryRate();

        // when
        var after = (FmpTreasuryRate) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = aFmpTreasuryRate();

        // when // then
        verifySerialization(o);
    }
}