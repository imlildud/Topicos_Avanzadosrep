package Practica7Junit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerificadorEdadTest {

    @BeforeEach
    void setup() {
        VerificadorEdad veri = new VerificadorEdad();
    }

    @Test
    void PruebaesMayorDeEdad() {
        assertTrue(VerificadorEdad.esMayorDeEdad(20));
    }

    @Test
    void PruebaesMenordeEdad() {
        assertFalse(VerificadorEdad.esMayorDeEdad(13));
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 20, 25, 30, 40, 50, 60, 70, 80, 90, 100})
    void testEsMayorDeEdad(int edad) {
        assertTrue(VerificadorEdad.esMayorDeEdad(edad));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10, 13, 17})
    void testEsMenorDeEdad(int edad) {
        assertFalse(VerificadorEdad.esMayorDeEdad(edad));
    }

    static Stream<Integer> mayoresEdad() {
        return Stream.iterate(18, n -> n + 1).limit(500);
    }

    static Stream<Integer> menoresEdad() {
        return Stream.iterate(0, n -> n + 1).limit(500);
    }
}