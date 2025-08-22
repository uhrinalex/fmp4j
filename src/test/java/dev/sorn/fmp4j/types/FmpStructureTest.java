package dev.sorn.fmp4j.types;

import static dev.sorn.fmp4j.types.FmpStructure.structure;
import static org.junit.jupiter.api.Assertions.*;

import dev.sorn.fmp4j.exceptions.FmpInvalidStructureException;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FmpStructureTest {

  @Test
  void valid_structure() {
    // given
    String structureValue = "flat";

    // when
    FmpStructure structure = structure(structureValue);

    // then
    assertEquals(structureValue, structure.value());
    assertEquals(structureValue, structure.toString());
  }

  @Test
  void invalid_structure() {
    // given
    String invalidStructureValue = "unknown";

    // when
    var e = assertThrows(FmpInvalidStructureException.class, () -> structure(invalidStructureValue));
    assertEquals("[unknown] is not a valid structure", e.getMessage());
  }
}