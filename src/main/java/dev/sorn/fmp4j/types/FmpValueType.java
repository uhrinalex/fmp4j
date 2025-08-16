package dev.sorn.fmp4j.types;

import java.io.Serializable;

@FunctionalInterface
public interface FmpValueType<T> extends Serializable {
    T value();
}