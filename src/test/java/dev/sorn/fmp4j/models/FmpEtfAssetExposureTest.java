package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.EtfAssetExposureTestData;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.deserialize;
import static dev.sorn.fmp4j.TestUtils.serialize;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpEtfAssetExposureTest implements EtfAssetExposureTestData {
    @Test
    void is_serializable() throws IOException, ClassNotFoundException {
        // given
        var before = anEtfAssetExposure();

        // when
        var after = (FmpEtfAssetExposure) deserialize(serialize(before));

        // then
        assertEquals(before, after);
    }
}