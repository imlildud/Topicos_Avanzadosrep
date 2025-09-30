package Practica7Junit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VerificadorEdadTest {

    @BeforeEach
    void setup(){
        VerificadorEdad veri = new VerificadorEdad();
    }

    @Test
    void PruebaesMayorDeEdad(){
        assertTrue(VerificadorEdad.esMayorDeEdad(20));
    }

    @Test
    void PruebaesMenordeEdad(){
        assertFalse(VerificadorEdad.esMayorDeEdad(13));
    }
}