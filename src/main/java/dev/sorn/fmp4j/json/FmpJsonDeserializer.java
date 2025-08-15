package dev.sorn.fmp4j.json;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;

public interface FmpJsonDeserializer {
    <T> T fromJson(String json, TypeReference<T> typeReference);
    <T> List<T> fromJsonArray(String json, TypeReference<T[]> typeReference);
}