package dev.sorn.fmp4j.services;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpDividendsCalendar;
import java.util.Set;
import static dev.sorn.fmp4j.json.FmpJsonUtils.typeRef;

public class FmpDividendsCalendarService extends FmpService<FmpDividendsCalendar[]> {
    public FmpDividendsCalendarService(
        FmpConfig cfg,
        FmpHttpClient http
    ) {
        super(cfg, http, typeRef(FmpDividendsCalendar[].class));
    }

    @Override
    protected String relativeUrl() {
        return "/dividends-calendar";
    }

    @Override
    protected Set<String> requiredParams() {
        return Set.of();
    }

    @Override
    protected Set<String> optionalParams() {
        return Set.of();
    }
}