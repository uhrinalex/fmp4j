package dev.sorn.fmp4j.types;

import static java.lang.String.valueOf;

import dev.sorn.fmp4j.exceptions.FmpInvalidLimitException;

final public class FmpLimit implements FmpValueObject<Integer> {
    public static final int MIN_LIMIT_VALUE = 1;
    public static final int MAX_LIMIT_VALUE = 1000;
    private final int value;

    private FmpLimit(int limit) {
        value = limit;
    }

    public static FmpLimit limit(int limit) {
        if (limit < MIN_LIMIT_VALUE) {
            throw new FmpInvalidLimitException("[%d] is below the minimum allowed value [%d]", limit, MIN_LIMIT_VALUE);
        }
        if (limit > MAX_LIMIT_VALUE) {
            throw new FmpInvalidLimitException("[%d] exceeds the maximum allowed value [%d]", limit, MAX_LIMIT_VALUE);
        }
        return new FmpLimit(limit);
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public String toString() {
        return valueOf(value);
    }
}
