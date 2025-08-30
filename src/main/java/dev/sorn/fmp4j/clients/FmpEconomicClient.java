package dev.sorn.fmp4j.clients;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpTreasuryRate;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.services.FmpTreasuryRatesService;

public class FmpEconomicClient {
    protected final FmpService<FmpTreasuryRate[]> fmpTreasuryRatesService;

    public FmpEconomicClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpTreasuryRatesService = new FmpTreasuryRatesService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpTreasuryRate[] treasuryRates(String from, String to) {
        fmpTreasuryRatesService.param("from", from);
        fmpTreasuryRatesService.param("to", to);
        return fmpTreasuryRatesService.download();
    }
}
