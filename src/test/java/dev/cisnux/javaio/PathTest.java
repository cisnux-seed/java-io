package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class PathTest {

    @Test
    void createPath() {
        final var path = Path.of("file.txt");

        Assertions.assertEquals("file.txt", path.toString());
        Assertions.assertFalse(path.isAbsolute());
    }

    @Test
    void usingFiles() {
        final var path = Path.of("pom.xml");

        Assertions.assertEquals("pom.xml", path.toString());
        Assertions.assertFalse(path.isAbsolute());
        Assertions.assertTrue(Files.exists(path));
    }
}
