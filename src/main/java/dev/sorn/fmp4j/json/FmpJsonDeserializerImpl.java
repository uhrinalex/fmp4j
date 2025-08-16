package dev.sorn.fmp4j.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class FmpJsonDeserializerImpl implements FmpJsonDeserializer {
    public static final FmpJsonDeserializerImpl JSON_DESERIALIZER = new FmpJsonDeserializerImpl();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    private FmpJsonDeserializerImpl() {
        // prevent direct instantiation
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            throw new FmpJsonException(e, "Failed to deserialize JSON to '%s': %s", clazz.getSimpleName(), json);
        }
    }

    public <T> List<T> fromJsonArray(String json, Class<T[]> clazz) {
        try {
            T[] array = OBJECT_MAPPER.readValue(json, clazz);
            return Arrays.asList(array);
        } catch (IOException e) {
            throw new FmpJsonException(e, "Failed to deserialize JSON to '%s': %s", clazz.getSimpleName(), json);
        }
    }
}