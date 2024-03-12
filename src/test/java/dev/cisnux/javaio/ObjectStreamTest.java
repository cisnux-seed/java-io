package dev.cisnux.javaio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamTest {
    @Test
    void savePerson() {
        Person person = new Person("1", "fajra");

        final var path = Path.of("users.bin");

        try (final var stream = Files.newOutputStream(path);
             final var objectOutputStream = new ObjectOutputStream(stream)
        ) {
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();

        } catch (IOException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void getPerson() {
        Path path = Path.of("users.bin");

        try (final var stream = Files.newInputStream(path);
             final var objectInputStream = new ObjectInputStream(stream)
        ) {
            final var person = (Person) objectInputStream.readObject();
            final var expectedPerson = new Person("1", "fajra");

            Assertions.assertEquals(expectedPerson, person);
        } catch (IOException | ClassNotFoundException exception) {
            Assertions.fail(exception);
        }
    }
}
