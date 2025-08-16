package dev.sorn.fmp4j.services;

import dev.sorn.fmp4j.BalanceSheetStatementTestData;
import dev.sorn.fmp4j.HttpClientStub;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.http.FmpHttpClientImpl;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static dev.sorn.fmp4j.HttpClientStub.httpClientStub;
import static dev.sorn.fmp4j.TestUtils.jsonTestResource;
import static dev.sorn.fmp4j.cfg.FmpConfigImpl.FMP_CONFIG;
import static dev.sorn.fmp4j.json.FmpJsonDeserializerImpl.FMP_JSON_DESERIALIZER;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FmpBalanceSheetStatementServiceTest implements BalanceSheetStatementTestData {
    private final HttpClientStub httpStub = httpClientStub();
    private final FmpHttpClient http = new FmpHttpClientImpl(httpStub, FMP_JSON_DESERIALIZER);
    private final FmpService<FmpBalanceSheetStatement[]> service = new FmpBalanceSheetStatementService(FMP_CONFIG, http);

    @Test
    void successful_download() {
        // given
        var symbol = "AAPL";
        service.param("symbol", symbol);
        httpStub.configureResponse()
            .body(jsonTestResource("stable/balance-sheet-statement/?symbol=%s.json", symbol))
            .statusCode(200)
            .apply();

        // when
        var result = service.download();

        // then
        assertEquals(5, result.length);
        assertEquals(anAnnualBalanceSheetStatement(), result[0]);
    }

    @ParameterizedTest
    @ValueSource(strings = {"annual", "quarter"})
    void successful_download_with_optional_period_and_limit(String period) {
        // given
        var symbol = "AAPL";
        var limit = 3;
        service.param("symbol", symbol);
        httpStub.configureResponse()
            .body(jsonTestResource("stable/balance-sheet-statement/?symbol=%s&period=%s&limit=%d.json", symbol, period, limit))
            .statusCode(200)
            .apply();

        // when
        var result = service.download();

        // then
        assertEquals(limit, result.length);
    }
}