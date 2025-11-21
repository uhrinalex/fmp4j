package dev.sorn.fmp4j.models;

import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static dev.sorn.fmp4j.types.FmpQuarter.Q1;
import static dev.sorn.fmp4j.types.FmpYear.year;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.sorn.fmp4j.EarningsCallTestData;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class FmpEarningsCallTranscriptDateTest implements EarningsCallTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = new FmpEarningsCallTranscriptDate(Q1, year(2020), LocalDate.parse("2020-03-31"));

        // when
        var after = (FmpEarningsCallTranscriptDate) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = new FmpEarningsCallTranscriptDate(Q1, year(2020), LocalDate.parse("2020-03-31"));

        // when // then
        verifySerialization(o);
    }
}
