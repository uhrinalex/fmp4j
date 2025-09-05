package dev.sorn.fmp4j.models;

import dev.sorn.fmp4j.types.FmpIsin;
import dev.sorn.fmp4j.types.FmpSymbol;
import java.io.Serial;
import java.time.LocalDate;

public record FmpCompany(
        FmpSymbol symbol,
        Double price,
        Long marketCap,
        Double beta,
        Double lastDividend,
        String range,
        Double change,
        Double changePercentage,
        Long volume,
        Long averageVolume,
        String companyName,
        String currency,
        String cik,
        FmpIsin isin,
        String cusip,
        String exchangeFullName,
        String exchange,
        String industry,
        String website,
        String description,
        String ceo,
        String sector,
        String country,
        String fullTimeEmployees,
        String phone,
        String address,
        String city,
        String state,
        String zip,
        String image,
        LocalDate ipoDate,
        Boolean defaultImage,
        Boolean isEtf,
        Boolean isActivelyTrading,
        Boolean isAdr,
        Boolean isFund)
        implements FmpModel {
    @Serial
    private static final long serialVersionUID = 3L;
}
