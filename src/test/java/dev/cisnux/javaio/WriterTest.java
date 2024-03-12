package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {
    @Test
    void writer() {
        final var path = Path.of("writer.txt");
        try (final var writer = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 100; i++) {
                writer.write("Hello World\n");
                writer.flush();
            }
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }
}
