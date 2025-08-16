package dev.sorn.fmp4j.services;

import dev.sorn.fmp4j.HttpClientStub;
import dev.sorn.fmp4j.RatioTtmTestData;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.http.FmpHttpClientImpl;
import dev.sorn.fmp4j.models.FmpRatioTtm;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.HttpClientStub.httpClientStub;
import static dev.sorn.fmp4j.TestUtils.jsonTestResource;
import static dev.sorn.fmp4j.cfg.FmpConfigImpl.FMP_CONFIG;
import static dev.sorn.fmp4j.json.FmpJsonDeserializerImpl.FMP_JSON_DESERIALIZER;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FmpRatioTtmServiceTest implements RatioTtmTestData {
    private final HttpClientStub httpStub = httpClientStub();
    private final FmpHttpClient http = new FmpHttpClientImpl(httpStub, FMP_JSON_DESERIALIZER);
    private final FmpService<FmpRatioTtm[]> service = new FmpRatioTtmService(FMP_CONFIG, http);

    @Test
    void successful_download() {
        // given
        var symbol = "AAPL";
        service.param("symbol", symbol);
        httpStub.configureResponse()
            .body(jsonTestResource("stable/ratios-ttm/?symbol=%s.json", symbol))
            .statusCode(200)
            .apply();

        // when
        var result = service.download();

        // then
        assertEquals(1, result.length);
        assertEquals(aTtmRatio(), result[0]);
    }
}