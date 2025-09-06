package dev.sorn.fmp4j.models;

import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.sorn.fmp4j.IncomeStatementGrowthTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class FmpIncomeStatementGrowthTest implements IncomeStatementGrowthTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = anIncomeStatementGrowth();

        // when
        var after = (FmpIncomeStatementGrowth) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = anIncomeStatementGrowth();

        // when // then
        verifySerialization(o);
    }
}
