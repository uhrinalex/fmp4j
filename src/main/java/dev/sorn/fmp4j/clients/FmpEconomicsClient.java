package dev.sorn.fmp4j.clients;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpTreasuryRate;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.services.FmpTreasuryRatesService;
import java.time.LocalDate;

public class FmpEconomicsClient {
    protected final FmpService<FmpTreasuryRate[]> fmpTreasuryRatesService;

    public FmpEconomicsClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpTreasuryRatesService = new FmpTreasuryRatesService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpTreasuryRate[] treasuryRates(LocalDate from, LocalDate to) {
        fmpTreasuryRatesService.param("from", from);
        fmpTreasuryRatesService.param("to", to);
        return fmpTreasuryRatesService.download();
    }
}
