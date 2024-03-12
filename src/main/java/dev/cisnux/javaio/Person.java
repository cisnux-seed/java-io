package dev.cisnux.javaio;

import java.io.Serial;
import java.io.Serializable;

public record Person(
        String id,
        String name
) implements Serializable {
    // migration version
    @Serial
    private static final long serialVersionUID = 1L;
}
