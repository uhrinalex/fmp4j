package dev.sorn.fmp4j.services;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpEtfAssetExposure;
import java.util.Set;
import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

public class FmpEtfAssetExposureService extends FmpService<FmpEtfAssetExposure[]> {
    public FmpEtfAssetExposureService(
        FmpConfig cfg,
        FmpHttpClient http
    ) {
        super(cfg, http, typeRef(FmpEtfAssetExposure[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/etf/asset-exposure";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("symbol");
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of();
    }
}