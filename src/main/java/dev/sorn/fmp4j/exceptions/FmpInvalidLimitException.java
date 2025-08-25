package dev.sorn.fmp4j.exceptions;

import static java.lang.String.format;

public class FmpInvalidLimitException extends RuntimeException {
    public FmpInvalidLimitException(String message, Object... args) {
        super(format(message, args));
    }
}
