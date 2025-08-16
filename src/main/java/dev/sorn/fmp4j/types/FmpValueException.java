package dev.sorn.fmp4j.types;

import static java.lang.String.format;

public class FmpValueException extends RuntimeException {
    public FmpValueException(String message, Object... args) {
        super(format(message, args));
    }
}