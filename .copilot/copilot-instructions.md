# Project Overview

fmp4j is a lightweight Java SDK for the Financial Modeling Prep (FMP) API.

Follow the existing architecture, naming conventions, and idioms.
Do not introduce new abstractions or unrelated refactors.

# Coding Style

- Match the established code style
- No unrelated changes
- Prefer static imports:
    - `ZERO` instead of `BigDecimal.ZERO`
    - `emptyMap()` instead of `Map.of()`
    - `symbol(String)` instead of `FmpSymbol.symbol(String)`
- Prefer value objects from `dev.sorn.fmp4j.types`
- For value objects/types, create a static factory method named after the type
  - Example: `symbol(String)` instead of `FmpSymbol.of(String)`
- All models must implement FmpModel and define `serialVersionUID`
  - `serialVersionUID` must be incremented if a model is changed

# Test Guidelines

Follow strict TDD and maintain 100% coverage.

## General

- Use `var` in tests (no `final var`, no explicit types)
- Prefer `*TestData` interfaces for fixtures

## Model Serialization

Always test serialization and deserialization.

Example:

```java

@Test
void is_serializable() throws Exception {
    // given
    var before = aRandomModel();

    // when
    var after = (FmpSomeModel) deserialize(serialize(before));

    // then
    assertEquals(before, after);
}

@Test
void serializes() throws Exception {
    // given
    var o = aRandomModel();

    // when // then
    verifySerialization(o);
}
```

## Test Naming

* Use snake_case
* Names must be clear and descriptive
* Never prefix with `test_` or `should_`

## Test Structure

Use BDD-like comment blocks:

```java
// given
// when
// then
```

## FMP Response Fixtures

* Use real FMP responses from `testFixtures/resources/stable`
* Filenames mirror endpoint paths
* Use `%3F` instead of `/` for Windows compatibility
