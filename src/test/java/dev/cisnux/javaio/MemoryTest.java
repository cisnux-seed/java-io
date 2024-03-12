package dev.cisnux.javaio;

import org.junit.jupiter.api.Test;

import java.io.StringWriter;

public class MemoryTest {
    @Test
    void memoryStream() {
        final var writer = new StringWriter();
        for (int i = 0; i < 10; i++) {
            writer.write("Hello World\n");
        }

        final var content = writer.getBuffer().toString();
        System.out.println(content);
    }
}
