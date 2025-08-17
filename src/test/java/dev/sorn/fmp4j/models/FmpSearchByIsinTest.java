package dev.sorn.fmp4j.models;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpSearchByIsinTest {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = new FmpSearchByIsin("AAPL", "Apple Inc.", "US0378331005", 3427916386000L);

        // when
        var after = (FmpSearchByIsin) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}