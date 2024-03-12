package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputStreamTest {
    @Test
    void read() {
        final var path = Path.of("pom.xml");
        try (final var stream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            int data;
            int counter = 0;
            while((data = stream.read()) != -1){
                builder.append((char)data);
                counter++;
            }
            System.out.println(builder);
            System.out.println(counter);
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void readBytes() {
        final var path = Path.of("pom.xml");
        try (final var stream = Files.newInputStream(path)) {
            final var builder = new StringBuilder();
            // read every 1024 chars
            byte[] bytes = new byte[1024];
            int length;
            int counter = 0;
            while((length = stream.read(bytes)) != -1){
                builder.append(new String(bytes, 0, length));
                counter++;
            }
            System.out.println(builder);
            System.out.println(counter);
        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }

}
