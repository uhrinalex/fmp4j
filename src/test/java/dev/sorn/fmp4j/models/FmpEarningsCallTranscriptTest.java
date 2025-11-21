package dev.sorn.fmp4j.models;

import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static dev.sorn.fmp4j.TestUtils.verifySerialization;
import static dev.sorn.fmp4j.types.FmpPeriod.FY;
import static dev.sorn.fmp4j.types.FmpSymbol.symbol;
import static dev.sorn.fmp4j.types.FmpYear.year;
import static org.junit.jupiter.api.Assertions.assertEquals;

import dev.sorn.fmp4j.EarningsCallTestData;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class FmpEarningsCallTranscriptTest implements EarningsCallTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = new FmpEarningsCallTranscript(
                symbol("XYZ"), FY, year(1999), LocalDate.parse("1999-12-31"), "Transcript content");

        // when
        var after = (FmpEarningsCallTranscript) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }

    @Test
    void serializes() throws IOException {
        // given
        var o = new FmpEarningsCallTranscript(
                symbol("XYZ"), FY, year(1999), LocalDate.parse("1999-12-31"), "Transcript content");

        // when // then
        verifySerialization(o);
    }
}
