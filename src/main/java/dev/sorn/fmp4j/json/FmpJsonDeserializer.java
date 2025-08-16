package dev.sorn.fmp4j.json;

import java.util.List;

public interface FmpJsonDeserializer {
    <T> T fromJson(String json, Class<T> clazz);
    <T> List<T> fromJsonArray(String json, Class<T[]> clazz);
}