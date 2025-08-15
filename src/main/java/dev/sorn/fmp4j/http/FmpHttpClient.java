package dev.sorn.fmp4j.http;

import com.fasterxml.jackson.core.type.TypeReference;
import java.net.URI;
import java.util.List;
import java.util.Map;

public interface FmpHttpClient {
    <T> T getJson(
        TypeReference<T> typeRef,
        URI uri,
        Map<String, String> headers,
        Map<String, Object> queryParams
    );

    <T> List<T> getJsonList(
        TypeReference<T[]> typeRef,
        URI uri,
        Map<String, String> headers,
        Map<String, Object> queryParams
    );
}