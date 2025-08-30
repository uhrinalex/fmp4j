package dev.sorn.fmp4j.clients;

import static dev.sorn.fmp4j.types.FmpSymbol.symbol;
import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FmpChartClientTest {
    private final FmpConfig cfg = mock(FmpConfig.class);
    private final FmpHttpClient http = mock(FmpHttpClient.class);
    private FmpChartClient client;

    @BeforeEach
    void setUp() {
        when(cfg.fmpApiKey()).thenReturn("abc123");
        client = new FmpChartClient(cfg, http);
    }

    @Test
    void fails_on_invalid_interval() {
        // given
        var symbol = symbol("AAPL");
        var interval = "2sec";

        // when // then
        var e = assertThrows(IllegalStateException.class, () -> client.historical(symbol, interval, empty(), empty()));
        assertEquals("Unexpected interval: 2sec", e.getMessage());
    }
}
