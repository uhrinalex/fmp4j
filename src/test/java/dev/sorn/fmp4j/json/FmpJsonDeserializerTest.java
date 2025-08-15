package dev.sorn.fmp4j.json;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.sorn.fmp4j.TestObject;
import dev.sorn.fmp4j.TestObjectValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static dev.sorn.fmp4j.json.FmpJsonDeserializerImpl.JSON_DESERIALIZER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FmpJsonDeserializerTest {
    private FmpJsonDeserializer deserializer;

    @BeforeEach
    void setUp() {
        deserializer = JSON_DESERIALIZER;
    }

    @Test
    void deserialize_object() {
        // given
        var json = """
            {
                "key": "key",
                "object": {
                    "value": 42
                }
            }
            """;

        // when
        var obj = deserializer.fromJson(json, new TypeReference<TestObject>() {});

        // then
        assertEquals("key", obj.key());
        assertEquals(new TestObjectValue(42), obj.object());
    }


    @Test
    void deserialize_array() {
        // given
        var json = """
            [
                {
                    "key": "key3",
                    "object": {
                        "value": 28
                    }
                },
                {
                    "key": "key7",
                    "object": {
                        "value": 42
                    }
                }
            ]
            """;

        // when
        var obj = deserializer.fromJsonArray(json, new TypeReference<TestObject[]>() {});

        // then
        assertEquals(2, obj.size());
        assertEquals("key3", obj.getFirst().key());
        assertEquals("key7", obj.getLast().key());
        assertEquals(new TestObjectValue(28), obj.getFirst().object());
        assertEquals(new TestObjectValue(42), obj.getLast().object());
    }

    @Test
    void deserialize_object_failsOnMalformedJson() {
        // given
        var malformedJson = "{";

        // when // then
        var e = assertThrows(FmpJsonException.class, () -> JSON_DESERIALIZER.fromJson(malformedJson, new TypeReference<TestObject>() {}));
        assertEquals("Failed to deserialize JSON to 'dev.sorn.fmp4j.TestObject': {", e.getMessage());
    }

    @Test
    void deserialize_array_failsOnMalformedJson() {
        // given
        var malformedJson = "[";

        // when // then
        var e = assertThrows(FmpJsonException.class, () -> JSON_DESERIALIZER.fromJsonArray(malformedJson, new TypeReference<TestObject[]>() {}));
        assertEquals("Failed to deserialize JSON to 'dev.sorn.fmp4j.TestObject[]': [", e.getMessage());
    }

    @Test
    void deserialize_object_failsOnTypeMismatch() {
        // given
        var mismatchedJson = """
            {
                "key": "key",
                "object": "not_an_object"
            }
            """;

        // when // then
        var e = assertThrows(FmpJsonException.class, () -> JSON_DESERIALIZER.fromJson(mismatchedJson, new TypeReference<TestObject>() {}));
        assertEquals("""
            Failed to deserialize JSON to 'dev.sorn.fmp4j.TestObject': {
                "key": "key",
                "object": "not_an_object"
            }
            """.replaceAll("\\s", ""), e.getMessage().replaceAll("\\s", ""));
    }

    @Test
    void deserialize_array_failsOnElementTypeMismatch() {
        var invalidElementJson = """
            [
                {"key": "valid", "object": {"value": 1}},
                {"key": "invalid", "object": "not_an_object"}
            ]
            """;

        // when // then
        var e = assertThrows(FmpJsonException.class, () -> JSON_DESERIALIZER.fromJson(invalidElementJson, new TypeReference<TestObject>() {}));
        assertEquals("""
            Failed to deserialize JSON to 'dev.sorn.fmp4j.TestObject': [
                {"key": "valid", "object": {"value": 1}},
                {"key": "invalid", "object": "not_an_object"}
            ]
            """.replaceAll("\\s", ""), e.getMessage().replaceAll("\\s", ""));
    }
}