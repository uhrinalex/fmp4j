package dev.sorn.fmp4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public final class TestUtils {
    private TestUtils() {
        throw new AssertionError(TestUtils.class.getSimpleName() + " cannot be instantiated.");
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
}