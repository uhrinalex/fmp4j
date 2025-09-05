package dev.sorn.fmp4j.exceptions;

import static java.lang.String.format;

public class FmpInvalidFormTypeException extends RuntimeException {
    public FmpInvalidFormTypeException(String message, Object... args) {
        super(format(message, args));
    }
}
