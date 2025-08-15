package dev.sorn.fmp4j;

public interface DummyTestData {
    default Dummy aDummy() {
        return new Dummy("Dummy42");
    }
}