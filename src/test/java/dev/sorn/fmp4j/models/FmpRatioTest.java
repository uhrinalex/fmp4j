package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.RatioTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FmpRatioTest implements RatioTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = anAnnualRatio();

        // when
        var after = (FmpRatio) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}