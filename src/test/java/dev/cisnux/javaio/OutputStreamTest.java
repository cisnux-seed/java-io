package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class OutputStreamTest {
    @Test
    void outputStream() {
        final var path = Path.of("output.txt");
        try (final var stream = Files.newOutputStream(path)) {
            for (int i = 0; i < 100; i++) {
                stream.write("Hello World\n".getBytes());
                stream.flush();
            }
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }
}