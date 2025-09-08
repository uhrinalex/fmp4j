package dev.sorn.fmp4j.services;

import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;
import static java.util.Arrays.stream;
import static java.util.Collections.emptySet;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpStock;
import java.util.Set;

public class FmpStockListService extends FmpService<FmpStock[]> {
    public FmpStockListService(FmpConfig cfg, FmpHttpClient http) {
        super(cfg, http, typeRef(FmpStock[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/stock-list";
    }

    @Override
    protected Set<String> requiredParams() {
        return emptySet();
    }

    @Override
    protected Set<String> optionalParams() {
        return emptySet();
    }

    @Override
    protected FmpStock[] filter(FmpStock[] stocks) {
        return stream(stocks).filter(s -> s.symbol() != null).toArray(FmpStock[]::new);
    }
}
