package dev.sorn.fmp4j.clients;

import static dev.sorn.fmp4j.types.FmpLimit.limit;
import static dev.sorn.fmp4j.types.FmpPage.page;
import static java.util.Optional.empty;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpNews;
import dev.sorn.fmp4j.services.FmpNewsService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpLimit;
import dev.sorn.fmp4j.types.FmpPage;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public class FmpNewsClient {

    // Alphabetical order
    protected FmpService<FmpNews[]> fmpCryptoNewsService;
    protected FmpService<FmpNews[]> fmpForexNewsService;
    protected FmpService<FmpNews[]> fmpStockNewsService;

    public FmpNewsClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpCryptoNewsService = new FmpNewsService(fmpConfig, fmpHttpClient, "crypto");
        this.fmpForexNewsService = new FmpNewsService(fmpConfig, fmpHttpClient, "forex");
        this.fmpStockNewsService = new FmpNewsService(fmpConfig, fmpHttpClient, "stock");
    }

    public synchronized FmpNews[] crypto(Set<FmpSymbol> symbols) {
        return crypto(symbols, empty(), empty(), empty(), empty());
    }

    public synchronized FmpNews[] forex(Set<FmpSymbol> symbols) {
        return forex(symbols, empty(), empty(), empty(), empty());
    }

    public synchronized FmpNews[] stock(Set<FmpSymbol> symbols) {
        return stock(symbols, empty(), empty(), empty(), empty());
    }

    public synchronized FmpNews[] crypto(
            Set<FmpSymbol> symbols,
            Optional<LocalDate> from,
            Optional<LocalDate> to,
            Optional<FmpPage> page,
            Optional<FmpLimit> limit) {
        return news(fmpCryptoNewsService, symbols, from, to, page, limit);
    }

    public synchronized FmpNews[] forex(
            Set<FmpSymbol> symbols,
            Optional<LocalDate> from,
            Optional<LocalDate> to,
            Optional<FmpPage> page,
            Optional<FmpLimit> limit) {
        return news(fmpForexNewsService, symbols, from, to, page, limit);
    }

    public synchronized FmpNews[] stock(
            Set<FmpSymbol> symbols,
            Optional<LocalDate> from,
            Optional<LocalDate> to,
            Optional<FmpPage> page,
            Optional<FmpLimit> limit) {
        return news(fmpStockNewsService, symbols, from, to, page, limit);
    }

    protected synchronized FmpNews[] news(
            FmpService<FmpNews[]> service,
            Set<FmpSymbol> symbols,
            Optional<LocalDate> from,
            Optional<LocalDate> to,
            Optional<FmpPage> page,
            Optional<FmpLimit> limit) {
        service.param("symbols", symbols);
        from.ifPresent(date -> service.param("from", date));
        to.ifPresent(date -> service.param("to", date));
        service.param("page", page.orElse(page(0)));
        service.param("limit", limit.orElse(limit(100)));
        return service.download();
    }
}
