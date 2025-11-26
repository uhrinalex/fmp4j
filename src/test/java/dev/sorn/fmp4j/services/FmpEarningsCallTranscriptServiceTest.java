package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.HttpClientStub.httpClientStub;
import static dev.sorn.fmp4j.TestUtils.assertAllFieldsNonNull;
import static dev.sorn.fmp4j.TestUtils.testResource;
import static dev.sorn.fmp4j.json.FmpJsonDeserializer.FMP_JSON_DESERIALIZER;
import static dev.sorn.fmp4j.types.FmpQuarter.quarter;
import static dev.sorn.fmp4j.types.FmpSymbol.symbol;
import static dev.sorn.fmp4j.types.FmpYear.year;
import static java.lang.String.format;
import static java.util.Collections.emptySet;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.sorn.fmp4j.HttpClientStub;
import dev.sorn.fmp4j.cfg.FmpConfigImpl;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.http.FmpHttpClientImpl;
import dev.sorn.fmp4j.models.FmpEarningsCallTranscript;
import dev.sorn.fmp4j.types.FmpLimit;
import dev.sorn.fmp4j.types.FmpQuarter;
import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;

class FmpEarningsCallTranscriptServiceTest {
    private final HttpClientStub httpStub = httpClientStub();
    private final FmpHttpClient http = new FmpHttpClientImpl(httpStub, FMP_JSON_DESERIALIZER);
    private final FmpService<FmpEarningsCallTranscript[]> service =
            new FmpEarningsCallTranscriptService(new FmpConfigImpl(), http);

    @Test
    void relative_url() {
        // given // when
        var relativeUrl = service.relativeUrl();

        // then
        assertEquals("/earning-call-transcript", relativeUrl);
    }

    @Test
    void required_params() {
        // given // when
        var params = service.requiredParams();

        // then
        assertEquals(Map.of("symbol", FmpSymbol.class, "year", FmpYear.class, "quarter", FmpQuarter.class), params);
    }

    @Test
    void optional_params() {
        // given // when
        var params = service.optionalParams();

        // then
        assertEquals(Map.of("limit", FmpLimit.class), params);
    }

    @Test
    void successful_download() {
        // given
        var symbol = symbol("AAPL");
        var year = year(2020);
        var quarter = quarter(3);
        service.param("symbol", symbol);
        service.param("year", year);
        service.param("quarter", quarter);
        httpStub.configureResponse()
                .body(testResource(
                        "stable/earning-call-transcript/?symbol=%s&year=%s&quarter=%s.json", symbol, year, quarter))
                .statusCode(200)
                .apply();

        // when
        var result = service.download();

        // then
        assertEquals(1, result.length);
        range(0, 1).forEach(i -> assertInstanceOf(FmpEarningsCallTranscript.class, result[i]));
        range(0, 1).forEach(i -> assertAllFieldsNonNull(result[i], emptySet()));
    }

    @Test
    void missing_symbol_throws() {
        // given
        service.param("year", year(2020));
        service.param("quarter", quarter(3));

        // when
        Consumer<FmpService<FmpEarningsCallTranscript[]>> f = FmpService::download;

        // then
        var e = assertThrows(FmpServiceException.class, () -> f.accept(service));
        assertEquals(format("'symbol' is a required query param for endpoint [%s]", service.url()), e.getMessage());
    }

    @Test
    void missing_year_throws() {
        // given
        service.param("symbol", symbol("AAPL"));
        service.param("quarter", quarter(3));

        // when
        Consumer<FmpService<FmpEarningsCallTranscript[]>> f = FmpService::download;

        // then
        var e = assertThrows(FmpServiceException.class, () -> f.accept(service));
        assertEquals(format("'year' is a required query param for endpoint [%s]", service.url()), e.getMessage());
    }

    @Test
    void missing_quarter_throws() {
        // given
        service.param("symbol", symbol("AAPL"));
        service.param("year", year(2020));

        // when
        Consumer<FmpService<FmpEarningsCallTranscript[]>> f = FmpService::download;

        // then
        var e = assertThrows(FmpServiceException.class, () -> f.accept(service));
        assertEquals(format("'quarter' is a required query param for endpoint [%s]", service.url()), e.getMessage());
    }

    @Test
    void unrecognized_param_throws() {
        var key = "unknown";
        var value = "value";

        // given // when
        BiConsumer<String, String> f = service::param;

        // then
        var e = assertThrows(FmpServiceException.class, () -> f.accept(key, value));
        assertEquals(
                format("'unknown' is not a recognized query param for endpoint [%s]", service.url()), e.getMessage());
    }
}
