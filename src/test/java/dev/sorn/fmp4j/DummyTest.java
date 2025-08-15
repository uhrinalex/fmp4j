package dev.sorn.fmp4j;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DummyTest {
    @Test
    void dummy_with_name() {
        // given
        String name = "Dummy42";

        // when
        var obj = new Dummy(name);

        // then
        assertEquals(name, obj.name());
    }
}