package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.EarningsTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.*;

class FmpEarningTest implements EarningsTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = anEarning();

        // when
        var after = (FmpEarning) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}