package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintStreamTest {
    @Test
    void console() {
        final var stream = System.out;

        stream.println("Hello World");
        stream.println("Hello World");
        stream.println("Hello World");
    }

    @Test
    void printStream() {
        final var path = Path.of("print.txt");

        try (final var outputStream = Files.newOutputStream(path);
             final var stream = new PrintStream(outputStream)) {

            stream.println("Hello World");
            stream.println("Hello World");
            stream.println("Hello World");

        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }
}
