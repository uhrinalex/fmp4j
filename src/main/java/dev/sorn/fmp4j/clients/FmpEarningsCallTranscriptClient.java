package dev.sorn.fmp4j.clients;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpLatestEarningsCallTranscript;
import dev.sorn.fmp4j.services.FmpLatestEarningsCallTranscriptService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpLimit;
import dev.sorn.fmp4j.types.FmpPage;

public class FmpEarningsCallTranscriptClient {

    // Alphabetical order
    protected final FmpService<FmpLatestEarningsCallTranscript[]> fmpEarningsCallTranscriptService;

    public FmpEarningsCallTranscriptClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpEarningsCallTranscriptService = new FmpLatestEarningsCallTranscriptService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpLatestEarningsCallTranscript[] transcripts(FmpLimit limit, FmpPage page) {
        fmpEarningsCallTranscriptService.param("limit", limit);
        fmpEarningsCallTranscriptService.param("page", page);
        return fmpEarningsCallTranscriptService.download();
    }
}
