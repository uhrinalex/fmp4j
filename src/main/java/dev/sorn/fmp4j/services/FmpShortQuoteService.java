package dev.sorn.fmp4j.services;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpShortQuote;
import java.util.Set;
import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

public class FmpShortQuoteService extends FmpService<FmpShortQuote[]> {
    public FmpShortQuoteService(
        FmpConfig cfg,
        FmpHttpClient http
    ) {
        super(cfg, http, typeRef(FmpShortQuote[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/quote-short";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("symbol");
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of();
    }
}