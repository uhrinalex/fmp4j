package dev.sorn.fmp4j.cfg;

import dev.sorn.fmp4j.types.FmpApiKey;

public interface FmpConfig {
    FmpApiKey fmpApiKey();

    String fmpBaseUrl();
}
