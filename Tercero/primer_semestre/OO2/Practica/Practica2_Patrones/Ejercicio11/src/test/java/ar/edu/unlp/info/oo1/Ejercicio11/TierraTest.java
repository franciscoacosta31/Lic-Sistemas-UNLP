package ar.edu.unlp.info.oo1.Ejercicio11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TierraTest {
    private Tierra tierra;

    @BeforeEach
    void setUp() {
        tierra = new Tierra();
    }

    @Test
    void testCalcularProporcion() {
        assertEquals(0.0, tierra.calcularProporcion());
    }

    @Test
    void testEsIgual() {
        assertTrue(tierra.esIgual(new Tierra()));
        assertFalse(tierra.esIgual(new Agua()));
        assertFalse(tierra.esIgual(new Mixta(List.of(new Agua(), new Tierra(), new Tierra(), new Tierra()))));
    }
}