package dev.sorn.fmp4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class TestUtils {
    private TestUtils() {
        throw new AssertionError(TestUtils.class.getSimpleName() + " cannot be instantiated.");
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
        for (final var field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                assertNotNull(field.get(obj), field.getName() + " should not be null");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("failed to access field: " + field.getName(), e);
            }
        }
    }
}