package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.BalanceSheetStatementTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FmpBalanceSheetStatementTest implements BalanceSheetStatementTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = anAnnualBalanceSheetStatement();

        // when
        var after = (FmpBalanceSheetStatement) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}