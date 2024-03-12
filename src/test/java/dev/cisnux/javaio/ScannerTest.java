package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ScannerTest {
    @Test
    void scanner() {
        final var path = Path.of("print.txt");
        try (final var stream = Files.newInputStream(path);
             final var scanner = new Scanner(stream)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }

}
