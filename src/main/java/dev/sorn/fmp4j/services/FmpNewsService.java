package dev.sorn.fmp4j.services;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpNews;
import java.util.Set;
import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

public class FmpNewsService extends FmpService<FmpNews[]> {
    private final String path;

    public FmpNewsService(FmpConfig cfg, FmpHttpClient http, String path) {
        super(cfg, http, typeRef(FmpNews[].class));
        this.path = path;
    }

    @Override
    protected String relativeUrl() {
        return "/news/" + path;
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of("symbols");
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of("from", "to", "page", "limit");
    }
}