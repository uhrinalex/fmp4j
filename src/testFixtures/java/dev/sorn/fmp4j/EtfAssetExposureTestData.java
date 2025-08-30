package dev.sorn.fmp4j;

import static dev.sorn.fmp4j.types.FmpSymbol.symbol;

import dev.sorn.fmp4j.models.FmpEtfAssetExposure;

public interface EtfAssetExposureTestData {
    default FmpEtfAssetExposure anEtfAssetExposure() {
        return new FmpEtfAssetExposure(symbol("VWUSX"), "NVO", 2143702L, 0.38, 184401246.04);
    }
}
