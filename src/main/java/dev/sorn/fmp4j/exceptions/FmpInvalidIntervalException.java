package dev.sorn.fmp4j.exceptions;

import static java.lang.String.format;

public class FmpInvalidIntervalException extends RuntimeException {
    public FmpInvalidIntervalException(String message, Object... args) {
        super(format(message, args));
    }
}
