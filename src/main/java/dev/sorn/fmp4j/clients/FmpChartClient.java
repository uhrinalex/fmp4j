package dev.sorn.fmp4j.clients;

import static dev.sorn.fmp4j.types.FmpInterval.FIFTEEN_MINUTE;
import static dev.sorn.fmp4j.types.FmpInterval.FIVE_MINUTE;
import static dev.sorn.fmp4j.types.FmpInterval.FOUR_HOUR;
import static dev.sorn.fmp4j.types.FmpInterval.ONE_HOUR;
import static dev.sorn.fmp4j.types.FmpInterval.ONE_MINUTE;
import static dev.sorn.fmp4j.types.FmpInterval.THIRTY_MINUTE;

import dev.sorn.fmp4j.cfg.FmpConfig;
import dev.sorn.fmp4j.http.FmpHttpClient;
import dev.sorn.fmp4j.models.FmpHistoricalChart;
import dev.sorn.fmp4j.models.FmpHistoricalPriceEodFull;
import dev.sorn.fmp4j.models.FmpHistoricalPriceEodLight;
import dev.sorn.fmp4j.services.FmpHistoricalChartService;
import dev.sorn.fmp4j.services.FmpHistoricalPriceEodFullService;
import dev.sorn.fmp4j.services.FmpHistoricalPriceEodLightService;
import dev.sorn.fmp4j.services.FmpService;
import dev.sorn.fmp4j.types.FmpInterval;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.util.Optional;

public class FmpChartClient {

    protected final FmpService<FmpHistoricalPriceEodLight[]> fmpHistoricalPriceEodLightService;
    protected final FmpService<FmpHistoricalPriceEodFull[]> fmpHistoricalPriceEodFullService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService1MinService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService5MinService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService15MinService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService30MinService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService1HourService;
    protected final FmpService<FmpHistoricalChart[]> fmpHistoricalChartService4HourService;

    public FmpChartClient(FmpConfig fmpConfig, FmpHttpClient fmpHttpClient) {
        this.fmpHistoricalPriceEodLightService = new FmpHistoricalPriceEodLightService(fmpConfig, fmpHttpClient);
        this.fmpHistoricalPriceEodFullService = new FmpHistoricalPriceEodFullService(fmpConfig, fmpHttpClient);
        this.fmpHistoricalChartService1MinService = new FmpHistoricalChartService(fmpConfig, fmpHttpClient, ONE_MINUTE);
        this.fmpHistoricalChartService5MinService =
                new FmpHistoricalChartService(fmpConfig, fmpHttpClient, FIVE_MINUTE);
        this.fmpHistoricalChartService15MinService =
                new FmpHistoricalChartService(fmpConfig, fmpHttpClient, FIFTEEN_MINUTE);
        this.fmpHistoricalChartService30MinService =
                new FmpHistoricalChartService(fmpConfig, fmpHttpClient, THIRTY_MINUTE);
        this.fmpHistoricalChartService1HourService = new FmpHistoricalChartService(fmpConfig, fmpHttpClient, ONE_HOUR);
        this.fmpHistoricalChartService4HourService = new FmpHistoricalChartService(fmpConfig, fmpHttpClient, FOUR_HOUR);
    }

    public synchronized FmpHistoricalPriceEodLight[] historicalPriceEodLight(
            FmpSymbol symbol, Optional<String> from, Optional<String> to) {
        fmpHistoricalPriceEodLightService.param("symbol", symbol);
        from.ifPresent(date -> fmpHistoricalPriceEodLightService.param("from", date));
        to.ifPresent(date -> fmpHistoricalPriceEodLightService.param("to", date));
        return fmpHistoricalPriceEodLightService.download();
    }

    public synchronized FmpHistoricalPriceEodFull[] historicalPriceEodFull(
            FmpSymbol symbol, Optional<String> from, Optional<String> to) {
        fmpHistoricalPriceEodFullService.param("symbol", symbol);
        from.ifPresent(date -> fmpHistoricalPriceEodFullService.param("from", date));
        to.ifPresent(date -> fmpHistoricalPriceEodFullService.param("to", date));
        return fmpHistoricalPriceEodFullService.download();
    }

    public synchronized FmpHistoricalChart[] historical(
            FmpSymbol symbol, FmpInterval interval, Optional<String> from, Optional<String> to) {
        return switch (interval) {
            case ONE_MINUTE -> {
                fmpHistoricalChartService1MinService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService1MinService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService1MinService.param("to", date));
                yield fmpHistoricalChartService1MinService.download();
            }
            case FIVE_MINUTE -> {
                fmpHistoricalChartService5MinService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService5MinService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService5MinService.param("to", date));
                yield fmpHistoricalChartService5MinService.download();
            }
            case FIFTEEN_MINUTE -> {
                fmpHistoricalChartService15MinService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService15MinService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService15MinService.param("to", date));
                yield fmpHistoricalChartService15MinService.download();
            }
            case THIRTY_MINUTE -> {
                fmpHistoricalChartService30MinService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService30MinService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService30MinService.param("to", date));
                yield fmpHistoricalChartService30MinService.download();
            }
            case ONE_HOUR -> {
                fmpHistoricalChartService1HourService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService1HourService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService1HourService.param("to", date));
                yield fmpHistoricalChartService1HourService.download();
            }
            case FOUR_HOUR -> {
                fmpHistoricalChartService4HourService.param("symbol", symbol);
                from.ifPresent(date -> fmpHistoricalChartService4HourService.param("from", date));
                to.ifPresent(date -> fmpHistoricalChartService4HourService.param("to", date));
                yield fmpHistoricalChartService4HourService.download();
            }
        };
    }
}
