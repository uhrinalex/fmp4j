package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.KeyMetricTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpKeyMetricTest implements KeyMetricTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = anAnnualKeyMetric();

        // when
        var after = (FmpKeyMetric) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}