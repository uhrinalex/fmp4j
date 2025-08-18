package dev.sorn.fmp4j;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpBalanceSheetStatement;
import dev.sorn.fmp4j.models.FmpCashFlowStatement;
import dev.sorn.fmp4j.models.FmpCompany;
import dev.sorn.fmp4j.models.FmpDividend;
import dev.sorn.fmp4j.models.FmpDividendsCalendar;
import dev.sorn.fmp4j.models.FmpEarning;
import dev.sorn.fmp4j.models.FmpEarningsCalendar;
import dev.sorn.fmp4j.models.FmpEtf;
import dev.sorn.fmp4j.models.FmpIncomeStatement;
import dev.sorn.fmp4j.models.FmpKeyMetric;
import dev.sorn.fmp4j.models.FmpKeyMetricTtm;
import dev.sorn.fmp4j.models.FmpRatio;
import dev.sorn.fmp4j.models.FmpRatioTtm;
import dev.sorn.fmp4j.models.FmpRevenueGeographicSegmentation;
import dev.sorn.fmp4j.models.FmpRevenueProductSegmentation;
import dev.sorn.fmp4j.models.FmpSearchByIsin;
import dev.sorn.fmp4j.models.FmpSearchByName;
import dev.sorn.fmp4j.models.FmpSearchBySymbol;
import dev.sorn.fmp4j.models.FmpShortQuote;
import dev.sorn.fmp4j.models.FmpStock;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.TestUtils.assertAllFieldsNonNull;
import static dev.sorn.fmp4j.TestUtils.jsonTestResource;
import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;
import static java.lang.String.format;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FmpClientTest {
    private static final String BASE_URL = "https://financialmodelingprep.com/stable";
    private static final String API_KEY = "424242";
    private final FmpConfig fmpConfig = mock(FmpConfig.class);
    private final FmpHttpClient fmpHttpClient = mock(FmpHttpClient.class);
    private FmpClient fmpClient;

    @BeforeEach
    void setUp() {
        when(fmpConfig.fmpBaseUrl()).thenReturn(BASE_URL);
        when(fmpConfig.fmpApiKey()).thenReturn(API_KEY);
        fmpClient = new FmpClient(fmpConfig, fmpHttpClient);
    }

    @Test
    void searchByIsin() {
        // given
        var isin = "NL0012969182";
        var typeRef = typeRef(FmpSearchByIsin[].class);
        var endpoint = "search-isin";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("isin", isin));
        var file = format("stable/%s/?isin=%s.json", endpoint, isin);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.searchByIsin(isin);

        // then
        assertValidResult(result, 3, FmpSearchByIsin.class);
    }

    @Test
    void searchByName() {
        // given
        var query = "ADYEN";
        var typeRef = typeRef(FmpSearchByName[].class);
        var endpoint = "search-name";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("query", query));
        var file = format("stable/%s/?query=%s.json", endpoint, query);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.searchByName(query);

        // then
        assertValidResult(result, 5, FmpSearchByName.class);
    }

    @Test
    void searchBySymbol() {
        // given
        var query = "ADYEN";
        var typeRef = typeRef(FmpSearchBySymbol[].class);
        var endpoint = "search-symbol";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("query", query));
        var file = format("stable/%s/?query=%s.json", endpoint, query);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.searchBySymbol(query);

        // then
        assertValidResult(result, 1, FmpSearchBySymbol.class);
    }

    @Test
    void stockList() {
        // given
        var typeRef = typeRef(FmpStock[].class);
        var endpoint = "stock-list";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of());
        var file = format("stable/%s/excerpt.json", endpoint);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.stockList();

        // then
        assertValidResult(result, 2, FmpStock.class);
    }

    @Test
    void etfList() {
        // given
        var typeRef = typeRef(FmpEtf[].class);
        var endpoint = "etf-list";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of());
        var file = format("stable/%s/excerpt.json", endpoint);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.etfList();

        // then
        assertValidResult(result, 4, FmpEtf.class);
    }

    @Test
    void dividends_calendar() {
        // given
        var typeRef = typeRef(FmpDividendsCalendar[].class);
        var endpoint = "dividends-calendar";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of());
        var file = format("stable/%s/excerpt.json", endpoint);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.dividendsCalendar();

        // then
        assertValidResult(result, 4, FmpDividendsCalendar.class, Set.of("declarationDate"));
    }

    @Test
    void dividends() {
        // given
        var typeRef = typeRef(FmpDividend[].class);
        var endpoint = "dividends";
        var symbol = "AAPL";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol));
        var file = format("stable/%s/?symbol=%s.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.dividends(symbol);

        // then
        assertValidResult(result, 4, FmpDividend.class, Set.of("declarationDate"));
    }

    @Test
    void earnings_calendar() {
        // given
        var typeRef = typeRef(FmpEarningsCalendar[].class);
        var endpoint = "earnings-calendar";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of());
        var file = format("stable/%s/excerpt.json", endpoint);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.earningsCalendar();

        // then
        assertValidResult(result, 4, FmpEarningsCalendar.class, Set.of("epsActual", "epsEstimated", "revenueActual", "revenueEstimated"));
    }

    @Test
    void earnings() {
        // given
        var typeRef = typeRef(FmpEarning[].class);
        var endpoint = "earnings";
        var symbol = "AAPL";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol));
        var file = format("stable/%s/?symbol=%s.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.earnings(symbol);

        // then
        assertValidResult(result, 4, FmpEarning.class, Set.of("epsActual", "epsEstimated", "revenueActual", "revenueEstimated"));
    }

    @Test
    void company() {
        // given
        var symbol = "AAPL";
        var typeRef = typeRef(FmpCompany[].class);
        var endpoint = "profile";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol));
        var file = format("stable/%s/?symbol=%s.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.company(symbol);

        // then
        assertValidResult(result, 1, FmpCompany.class);
    }

    @Test
    void incomeStatements() {
        // given
        var symbol = "AAPL";
        var period = "annual";
        var limit = 3;
        var typeRef = typeRef(FmpIncomeStatement[].class);
        var endpoint = "income-statement";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol, "period", period, "limit", limit));
        var file = format("stable/%s/?symbol=%s&period=annual&limit=3.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.incomeStatements(symbol, Optional.of(period), Optional.of(limit));

        // then
        assertValidResult(result, limit, FmpIncomeStatement.class);
    }

    @Test
    void balanceSheetStatements() {
        // given
        var symbol = "AAPL";
        var period = "annual";
        var limit = 3;
        var typeRef = typeRef(FmpBalanceSheetStatement[].class);
        var endpoint = "balance-sheet-statement";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol, "period", period, "limit", limit));
        var file = format("stable/%s/?symbol=%s&period=annual&limit=3.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.balanceSheetStatements(symbol, Optional.of(period), Optional.of(limit));

        // then
        assertValidResult(result, limit, FmpBalanceSheetStatement.class);
    }

    @Test
    void cashFlowStatements() {
        // given
        var symbol = "AAPL";
        var period = "annual";
        var limit = 3;
        var typeRef = typeRef(FmpCashFlowStatement[].class);
        var endpoint = "cash-flow-statement";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol, "period", period, "limit", limit));
        var file = format("stable/%s/?symbol=%s&period=annual&limit=3.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.cashFlowStatements(symbol, Optional.of(period), Optional.of(limit));

        // then
        assertValidResult(result, limit, FmpCashFlowStatement.class);
    }

    @Test
    void ratios() {
        // given
        var symbol = "AAPL";
        var period = "annual";
        var limit = 3;
        var typeRef = typeRef(FmpRatio[].class);
        var endpoint = "ratios";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol, "period", period, "limit", limit));
        var file = format("stable/%s/?symbol=%s&period=annual&limit=3.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.ratios(symbol, Optional.of(period), Optional.of(limit));

        // then
        assertValidResult(result, limit, FmpRatio.class);
    }

    @Test
    void ratiosTtm() {
        // given
        var symbol = "AAPL";
        var typeRef = typeRef(FmpRatioTtm[].class);
        var endpoint = "ratios-ttm";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol));
        var file = format("stable/%s/?symbol=%s.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.ratiosTtm(symbol);

        // then
        assertValidResult(result, 1, FmpRatioTtm.class);
    }

    @Test
    void keyMetrics() {
        // given
        var symbol = "AAPL";
        var period = "annual";
        var limit = 3;
        var typeRef = typeRef(FmpKeyMetric[].class);
        var endpoint = "key-metrics";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol, "period", period, "limit", limit));
        var file = format("stable/%s/?symbol=%s&period=annual&limit=3.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.keyMetrics(symbol, Optional.of(period), Optional.of(limit));

        // then
        assertValidResult(result, limit, FmpKeyMetric.class);
    }

    @Test
    void keyMetricsTtm() {
        // given
        var symbol = "AAPL";
        var typeRef = typeRef(FmpKeyMetricTtm[].class);
        var endpoint = "key-metrics-ttm";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol));
        var file = format("stable/%s/?symbol=%s.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.keyMetricTtm(symbol);

        // then
        assertValidResult(result, 1, FmpKeyMetricTtm.class);
    }

    @Test
    void revenueProductSegmentation() {
        // given
        var symbol = "AAPL";
        var period = "annual";
        var structure = "flat";
        var typeRef = typeRef(FmpRevenueProductSegmentation[].class);
        var endpoint = "revenue-product-segmentation";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol, "period", period, "structure", structure));
        var file = format("stable/%s/?symbol=%s&period=%s&structure=%s.json", endpoint, symbol, period, structure);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.revenueProductSegmentations(symbol, Optional.of(period), Optional.of(structure));

        // then
        assertValidResult(result, 15, FmpRevenueProductSegmentation.class, Set.of("reportedCurrency"));
    }

    @Test
    void revenueGeographicSegmentation() {
        // given
        var symbol = "AAPL";
        var period = "annual";
        var structure = "flat";
        var typeRef = typeRef(FmpRevenueGeographicSegmentation[].class);
        var endpoint = "revenue-geographic-segmentation";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol, "period", period, "structure", structure));
        var file = format("stable/%s/?symbol=%s&period=%s&structure=%s.json", endpoint, symbol, period, structure);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.revenueGeographicSegmentations(symbol, Optional.of(period), Optional.of(structure));

        // then
        assertValidResult(result, 15, FmpRevenueGeographicSegmentation.class, Set.of("reportedCurrency"));
    }

    @Test
    void shortQuotes() {
        // given
        var symbol = "AAPL";
        var typeRef = typeRef(FmpShortQuote[].class);
        var endpoint = "quote-short";
        var uri = buildUri(endpoint);
        var headers = defaultHeaders();
        var params = buildParams(Map.of("symbol", symbol));
        var file = format("stable/%s/?symbol=%s.json", endpoint, symbol);

        // when
        mockHttpGet(uri, headers, params, file, typeRef);
        var result = fmpClient.shortQuotes(symbol);

        // then
        assertValidResult(result, 1, FmpShortQuote.class);
    }

    private URI buildUri(String endpoint) {
        return URI.create(BASE_URL + "/" + endpoint);
    }

    private Map<String, String> defaultHeaders() {
        return Map.of("Content-Type", "application/json");
    }

    private Map<String, Object> buildParams(Map<String, Object> customParams) {
        return new HashMap<>() {{
            putAll(customParams);
            put("apikey", API_KEY);
        }};
    }

    private <T> void mockHttpGet(URI uri, Map<String, String> headers, Map<String, Object> params, String file, TypeReference<T> typeRef) {
        when(fmpHttpClient.get(any(), eq(uri), eq(headers), eq(params))).thenReturn(jsonTestResource(typeRef, file));
    }

    private <T> void assertValidResult(T[] result, int expectedLength, Class<?> expectedType) {
        assertValidResult(result, expectedLength, expectedType, Set.of());
    }

    private <T> void assertValidResult(T[] result, int expectedLength, Class<?> expectedType, Set<String> ignoreFields) {
        assertNotNull(result);
        assertEquals(expectedLength, result.length);
        range(0, expectedLength).forEach(i -> assertInstanceOf(expectedType, result[i]));
        range(0, expectedLength).forEach(i -> assertAllFieldsNonNull(result[i], ignoreFields));
    }
}