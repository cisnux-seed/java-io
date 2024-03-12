package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderTest {
    @Test
    void read() {
        final var path = Path.of("output.txt");
        try (final var reader = Files.newBufferedReader(path)) {
            final var builder = new StringBuilder();
            int character;
            int counter = 0;
            while ((character = reader.read()) != -1){
                builder.append((char)character);
                counter++;
            }
            System.out.println(builder);
            System.out.println(counter);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void readChars() {
        final var path = Path.of("output.txt");
        try (final var reader = Files.newBufferedReader(path)) {
            StringBuilder builder = new StringBuilder();
            char[] chars = new char[1024];
            int length;
            int counter = 0;
            while ((length = reader.read(chars)) != -1){
                builder.append(chars, 0, length);
                counter++;
            }
            System.out.println(builder);
            System.out.println(counter);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
