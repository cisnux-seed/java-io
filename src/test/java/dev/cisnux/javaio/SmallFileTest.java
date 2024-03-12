package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SmallFileTest {
    @Test
    void writeSmallFile() throws IOException {
        final var path1 = Path.of("small1.txt");
        final var bytes = "Hello World".getBytes();
        Files.write(path1, bytes);
        Assertions.assertTrue(Files.exists(path1));

        final var path2 = Path.of("small2.txt");
        Files.writeString(path2, "Hello World");
        Assertions.assertTrue(Files.exists(path2));
    }

    @Test
    void readSmallFile() throws IOException {
        final var path1 = Path.of("small1.txt");
        // bytes
        final var bytes = Files.readAllBytes(path1);
        final var content1 = new String(bytes);
        Assertions.assertEquals("Hello World", content1);

        // string
        final var path2 = Path.of("small2.txt");
        final var content2 = Files.readString(path2);
        Assertions.assertEquals("Hello World", content2);
    }
}
