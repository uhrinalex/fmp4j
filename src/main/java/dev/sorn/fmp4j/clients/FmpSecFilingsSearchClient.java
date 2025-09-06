package dev.sorn.fmp4j.clients;

import static dev.sorn.fmp4j.types.FmpLimit.limit;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpSecFilingsSearchBySymbol;
import dev.sorn.fmp4j.services.FmpSecFilingsSearchBySymbolService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpLimit;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.time.LocalDate;
import java.util.Optional;

public class FmpSecFilingsSearchClient {
    protected static final int FIRST_PAGE = 0;
    protected static final FmpLimit DEFAULT_LIMIT = limit(100);
    protected final FmpService<FmpSecFilingsSearchBySymbol[]> fmpSecFilingsSearchBySymbol;

    public FmpSecFilingsSearchClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpSecFilingsSearchBySymbol = new FmpSecFilingsSearchBySymbolService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpSecFilingsSearchBySymbol[] bySymbol(
            FmpSymbol symbol, LocalDate from, LocalDate to, Optional<Integer> page, Optional<FmpLimit> limit) {
        fmpSecFilingsSearchBySymbol.param("symbol", symbol);
        fmpSecFilingsSearchBySymbol.param("from", from);
        fmpSecFilingsSearchBySymbol.param("to", to);
        fmpSecFilingsSearchBySymbol.param("page", page.orElse(FIRST_PAGE));
        fmpSecFilingsSearchBySymbol.param("limit", limit.orElse(DEFAULT_LIMIT));
        return fmpSecFilingsSearchBySymbol.download();
    }
}
