package dev.sorn.fmp4j;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import static dev.sorn.fmp4j.json.FmpJsonDeserializerImpl.FMP_JSON_DESERIALIZER;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class TestUtils {
    private TestUtils() {
        throw new AssertionError(TestUtils.class.getSimpleName() + " cannot be instantiated.");
    }

    public static <T> T jsonTestResource(TypeReference<T> typeRef, String filename, Object... args) {
        final var json = jsonTestResource(filename, args);
        return FMP_JSON_DESERIALIZER.fromJson(json, typeRef);
    }

    public static String jsonTestResource(String filename, Object... args) {
        try (final var inputStream = TestUtils.class.getClassLoader().getResourceAsStream(format(filename, args))) {
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] serialize(Object o) throws IOException {
        var baos = new ByteArrayOutputStream();
        try (var oos = new ObjectOutputStream(baos)) {
            oos.writeObject(o);
        }
        return baos.toByteArray();
    }

    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        var after = (Object) null;
        var bais = new ByteArrayInputStream(bytes);
        try (var ois = new ObjectInputStream(bais)) {
            after = ois.readObject();
        }
        return after;
    }

    public static void assertAllFieldsNonNull(Object obj) {
        assertAllFieldsNonNull(obj, Set.of());
    }

    public static void assertAllFieldsNonNull(Object obj, Set<String> ignoreFields) {
        for (final var field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (!ignoreFields.contains(field.getName())) {
                    assertNotNull(field.get(obj), field.getName() + " should not be null");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("failed to access field: " + field.getName(), e);
            }
        }
    }
}