package dev.sorn.fmp4j.models;

import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.sorn.fmp4j.IposCalendarTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class FmpIposCalendarTest implements IposCalendarTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = anIposCalendarRecord();

        // when
        var after = (FmpIposCalendar) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = anIposCalendarRecord();

        // when // then
        verifySerialization(o);
    }
}
