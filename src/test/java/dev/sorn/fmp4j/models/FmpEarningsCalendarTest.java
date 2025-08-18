package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.EarningsCalendarTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpEarningsCalendarTest implements EarningsCalendarTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = anEarningsCalendarRecord();

        // when
        var after = (FmpEarningsCalendar) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}