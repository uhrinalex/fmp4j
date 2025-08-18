package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.DividendsTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.*;

class FmpDividendTest implements DividendsTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = aDividend();

        // when
        var after = (FmpDividend) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}