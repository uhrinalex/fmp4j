package dev.sorn.fmp4j.clients;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpDividend;
import dev.sorn.fmp4j.models.FmpDividendsCalendar;
import dev.sorn.fmp4j.models.FmpEarning;
import dev.sorn.fmp4j.models.FmpEarningsCalendar;
import dev.sorn.fmp4j.models.FmpIposCalendar;
import dev.sorn.fmp4j.models.FmpIposDisclosure;
import dev.sorn.fmp4j.models.FmpIposProspectus;
import dev.sorn.fmp4j.services.FmpDividendService;
import dev.sorn.fmp4j.services.FmpDividendsCalendarService;
import dev.sorn.fmp4j.services.FmpEarningService;
import dev.sorn.fmp4j.services.FmpEarningsCalendarService;
import dev.sorn.fmp4j.services.FmpIposCalendarService;
import dev.sorn.fmp4j.services.FmpIposDisclosureService;
import dev.sorn.fmp4j.services.FmpIposProspectusService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpSymbol;

public class FmpCalendarClient {

    protected final FmpService<FmpDividend[]> fmpDividendService;
    protected final FmpService<FmpDividendsCalendar[]> fmpDividendsCalendarService;
    protected final FmpService<FmpEarning[]> fmpEarningsService;
    protected final FmpService<FmpEarningsCalendar[]> fmpEarningsCalendarService;
    protected final FmpService<FmpIposCalendar[]> fmpIposCalendarService;
    protected final FmpService<FmpIposDisclosure[]> fmpIposDisclosureService;
    protected final FmpService<FmpIposProspectus[]> fmpIposProspectusService;

    public FmpCalendarClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpDividendService = new FmpDividendService(fmpConfig, fmpHttpClient);
        this.fmpDividendsCalendarService = new FmpDividendsCalendarService(fmpConfig, fmpHttpClient);
        this.fmpEarningsService = new FmpEarningService(fmpConfig, fmpHttpClient);
        this.fmpEarningsCalendarService = new FmpEarningsCalendarService(fmpConfig, fmpHttpClient);
        this.fmpIposCalendarService = new FmpIposCalendarService(fmpConfig, fmpHttpClient);
        this.fmpIposDisclosureService = new FmpIposDisclosureService(fmpConfig, fmpHttpClient);
        this.fmpIposProspectusService = new FmpIposProspectusService(fmpConfig, fmpHttpClient);
    }

    public synchronized FmpDividendsCalendar[] dividends() {
        return fmpDividendsCalendarService.download();
    }

    public synchronized FmpDividend[] dividends(FmpSymbol symbol) {
        fmpDividendService.param("symbol", symbol);
        return fmpDividendService.download();
    }

    public synchronized FmpEarningsCalendar[] earnings() {
        return fmpEarningsCalendarService.download();
    }

    public synchronized FmpEarning[] earnings(FmpSymbol symbol) {
        fmpEarningsService.param("symbol", symbol);
        return fmpEarningsService.download();
    }

    public synchronized FmpIposCalendar[] iposCalendar() {
        return fmpIposCalendarService.download();
    }

    public synchronized FmpIposDisclosure[] iposDisclosures() {
        return fmpIposDisclosureService.download();
    }

    public synchronized FmpIposProspectus[] iposProspectus() {
        return fmpIposProspectusService.download();
    }
}
