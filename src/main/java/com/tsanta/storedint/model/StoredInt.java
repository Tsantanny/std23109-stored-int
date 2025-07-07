package com.tsanta.storedint.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class StoredInt {

    private static final String FILE_PATH = "/tmp/stored-int.txt";
    private static final Path path = Path.of(FILE_PATH);

    public String getStoredInt() {
        File file = new File(FILE_PATH);

        if (file.exists()) {
            try {
                String content = Files.readString(path).trim();
                return "Stored number: " + content;
            } catch (IOException e) {
                throw new RuntimeException("Failed to read stored number: " + e.getMessage(), e);
            }
        } else {
            int randomInt = new Random().nextInt(1000);
            try {
                Files.writeString(path, String.valueOf(randomInt));
                return "Generated number: " + randomInt;
            } catch (IOException e) {
                throw new RuntimeException("Failed to write stored number: " + e.getMessage(), e);
            }
        }
    }
}
