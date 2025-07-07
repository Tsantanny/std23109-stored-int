package com.tsanta.storedint.model;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StoredIntTest {

  private static final Path path = Path.of("/tmp/stored-int.txt");

  private StoredInt storedInt;

  @BeforeEach
  void setUp() throws Exception {
    Files.deleteIfExists(path);
    storedInt = new StoredInt();
  }

  @AfterEach
  void tearDown() throws Exception {
    Files.deleteIfExists(path);
  }

  @Test
  void test_generated_number_when_file_does_not_exist() {
    String result = storedInt.getStoredInt();
    assertTrue(
        result.startsWith("Generated number: "),
        "Expected result to start with 'Generated number: '");

    String storedValue = readFile();
    assertTrue(result.endsWith(storedValue), "Returned value should match file content");
  }

  @Test
  void test_stored_number_when_file_exists() throws Exception {
    Files.writeString(path, "123");

    String result = storedInt.getStoredInt();
    assertEquals("Stored number: 123", result);
  }

  private String readFile() {
    try {
      return Files.readString(path).trim();
    } catch (Exception e) {
      fail("Could not read test file: " + e.getMessage());
      return null;
    }
  }
}
