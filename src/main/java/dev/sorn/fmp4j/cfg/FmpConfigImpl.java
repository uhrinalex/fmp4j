package dev.sorn.fmp4j.cfg;

import static java.lang.System.getProperty;
import static java.lang.System.getenv;

public final class FmpConfigImpl implements FmpConfig {
    public static final String FMP4J_API_KEY_ENV = "FMP_API_KEY";
    public static final String FMP4J_BASE_URL_ENV = "FMP_BASE_URL";

    private final String fmpApiKey;
    private final String fmpBaseUrl;

    public FmpConfigImpl() {
        fmpApiKey = getRequiredEnv(FMP4J_API_KEY_ENV);
        fmpBaseUrl = getRequiredEnv(FMP4J_BASE_URL_ENV);
    }

    private String getRequiredEnv(String name) {
        var value = getProperty(name);
        if (value == null || value.isBlank()) {
            value = getenv(name);
        }
        if (value == null || value.isBlank()) {
            throw new FmpConfigException("Missing required environment variable: %s", name);
        }
        return value;
    }

    @Override
    public String fmpApiKey() {
        return fmpApiKey;
    }

    @Override
    public String fmpBaseUrl() {
        return fmpBaseUrl;
    }
}
