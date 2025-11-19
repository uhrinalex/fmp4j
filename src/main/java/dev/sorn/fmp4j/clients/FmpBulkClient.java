package dev.sorn.fmp4j.clients;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpCompanies;
import dev.sorn.fmp4j.services.FmpCompaniesService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpPart;

public class FmpBulkClient {

    // Alphabetical order
    protected final FmpService<FmpCompanies[]> fmpByPartService;

    public FmpBulkClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpByPartService = new FmpCompaniesService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpCompanies[] byPart(FmpPart part) {
        fmpByPartService.param("part", part);
        return fmpByPartService.download();
    }
}
