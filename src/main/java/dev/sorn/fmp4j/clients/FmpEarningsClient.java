package dev.sorn.fmp4j.clients;

import static dev.sorn.fmp4j.types.FmpLimit.limit;
import static dev.sorn.fmp4j.types.FmpPage.page;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpEarningsCallTranscript;
import dev.sorn.fmp4j.models.FmpEarningsCallTranscriptDate;
import dev.sorn.fmp4j.models.FmpEarningsCallTranscriptLatest;
import dev.sorn.fmp4j.models.FmpEarningsCallTranscriptList;
import dev.sorn.fmp4j.services.FmpEarningsCallTranscriptDatesService;
import dev.sorn.fmp4j.services.FmpEarningsCallTranscriptLatestService;
import dev.sorn.fmp4j.services.FmpEarningsCallTranscriptListService;
import dev.sorn.fmp4j.services.FmpEarningsCallTranscriptService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpLimit;
import dev.sorn.fmp4j.types.FmpPage;
import dev.sorn.fmp4j.types.FmpQuarter;
import dev.sorn.fmp4j.types.FmpSymbol;
import dev.sorn.fmp4j.types.FmpYear;
import java.util.Optional;

public class FmpEarningsClient {

    // Alphabetical order
    protected final FmpService<FmpEarningsCallTranscript[]> fmpEarningsCallTranscriptService;
    protected final FmpService<FmpEarningsCallTranscriptDate[]> fmpEarningsCallTranscriptDatesService;
    protected final FmpService<FmpEarningsCallTranscriptLatest[]> fmpEarningsCallTranscriptLatestService;
    protected final FmpService<FmpEarningsCallTranscriptList[]> fmpEarningsCallTranscriptListService;

    public FmpEarningsClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpEarningsCallTranscriptService = new FmpEarningsCallTranscriptService(fmpConfig, fmpHttpClient);
        this.fmpEarningsCallTranscriptDatesService =
                new FmpEarningsCallTranscriptDatesService(fmpConfig, fmpHttpClient);
        this.fmpEarningsCallTranscriptLatestService =
                new FmpEarningsCallTranscriptLatestService(fmpConfig, fmpHttpClient);
        this.fmpEarningsCallTranscriptListService = new FmpEarningsCallTranscriptListService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpEarningsCallTranscript[] transcripts(
            FmpSymbol symbol, FmpYear year, FmpQuarter quarter, Optional<FmpLimit> limit) {
        fmpEarningsCallTranscriptService.param("symbol", symbol);
        fmpEarningsCallTranscriptService.param("year", year);
        fmpEarningsCallTranscriptService.param("quarter", quarter);
        limit.ifPresent(l -> fmpEarningsCallTranscriptService.param("limit", l));
        return fmpEarningsCallTranscriptService.download();
    }

    public synchronized FmpEarningsCallTranscriptDate[] dates(FmpSymbol symbol) {
        fmpEarningsCallTranscriptDatesService.param("symbol", symbol);
        return fmpEarningsCallTranscriptDatesService.download();
    }

    public synchronized FmpEarningsCallTranscriptLatest[] latest(Optional<FmpLimit> limit, Optional<FmpPage> page) {
        fmpEarningsCallTranscriptLatestService.param("limit", limit.orElse(limit(100)));
        fmpEarningsCallTranscriptLatestService.param("page", page.orElse(page(0)));
        return fmpEarningsCallTranscriptLatestService.download();
    }

    public synchronized FmpEarningsCallTranscriptList[] list() {
        return fmpEarningsCallTranscriptListService.download();
    }
}
