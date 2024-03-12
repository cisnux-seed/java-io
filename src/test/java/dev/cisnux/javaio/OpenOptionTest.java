package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenOptionTest {
    @Test
    void append() {
        final var path = Path.of("append.txt");
        try (final var writer = Files.newBufferedWriter(
                path,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
        )) {
            writer.write("Hello World\n");
            writer.flush();
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }
}
