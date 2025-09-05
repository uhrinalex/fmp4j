package dev.sorn.fmp4j.exceptions;

import static java.lang.String.format;

public class FmpInvalidIsinException extends RuntimeException {
    public FmpInvalidIsinException(String message, Object... args) {
        super(format(message, args));
    }
}
