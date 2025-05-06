package ar.edu.unlp.info.oo1.Ejercicio11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AguaTest {
    private Agua agua;

    @BeforeEach
    void setUp() {
        agua = new Agua();
    }

    @Test
    void testCalcularProporcion() {
        assertEquals(1.0, agua.calcularProporcion());
    }

    @Test
    void testEsIgual() {
        assertTrue(agua.esIgual(new Agua()));
        assertFalse(agua.esIgual(new Tierra()));
        assertFalse(agua.esIgual(new Mixta(List.of(new Agua(), new Tierra(), new Tierra(), new Tierra()))));
    }
}