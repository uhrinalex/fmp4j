package dev.sorn.fmp4j.types;

import static dev.sorn.fmp4j.types.FmpLimit.MAX_LIMIT_VALUE;
import static dev.sorn.fmp4j.types.FmpLimit.MIN_LIMIT_VALUE;
import static dev.sorn.fmp4j.types.FmpLimit.limit;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dev.sorn.fmp4j.exceptions.FmpInvalidLimitException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class FmpLimitTest {
    @ParameterizedTest
    @ValueSource(ints = {
        1,
        10,
        100,
        1000
    })
    void valid_limit(Integer limit) {
        // when
        var lim = limit(limit);

        // then
        assertEquals(limit, lim.value());
    }

    @Test
    void below_minimum_limit() {
        // given
        var limit = 0;

        // when // then
        var e = assertThrows(FmpInvalidLimitException.class, () -> limit(limit));
        assertEquals(format("[%d] is below the minimum allowed value [%d]", limit, MIN_LIMIT_VALUE), e.getMessage());
    }

    @Test
    void exceed_maximum_limit() {
        // given
        var limit = 1001;

        // when // then
        var e = assertThrows(FmpInvalidLimitException.class, () -> limit(limit));
        assertEquals(format("[%d] exceeds the maximum allowed value [%d]", limit, MAX_LIMIT_VALUE), e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {
        10,
        50
    })
    void toString_returns_value(Integer limit) {
        // when
        var lim = limit(limit);

        // then
        assertEquals(lim.toString(), valueOf(limit));
    }
}