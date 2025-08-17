package dev.sorn.fmp4j.models;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpEtfTest {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = new FmpEtf("GULF", "WisdomTree Middle East Dividend Fund");

        // when
        var after = (FmpEtf) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}