package dev.sorn.fmp4j.types;

import java.io.Serial;
import java.util.regex.Pattern;
import static java.util.Locale.ROOT;
import static java.util.Objects.requireNonNull;

public record FmpTicker(String value) implements FmpValueType<String> {
    @Serial
    private static final long serialVersionUID = 1L;

    public static final Pattern TICKER_PATTERN = Pattern.compile("^(?:[A-Z]{1,6}:)?[A-Z0-9]{1,6}(?:[.\\-/][A-Z][A-Z0-9]{0,3})?$");
    public FmpTicker {
        requireNonNull(value, "ticker value is required");
        value = value.strip();
        value = value.toUpperCase(ROOT);
        if (!TICKER_PATTERN.matcher(value).matches()) {
            throw new FmpValueException("ticker value [%s] does not match pattern [%s]", value, TICKER_PATTERN.pattern());
        }
    }

    public static FmpTicker ticker(String value) {
        return new FmpTicker(value);
    }
}