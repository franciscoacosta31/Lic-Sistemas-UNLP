package ar.edu.unlp.info.oo1.ejercicio9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class CuentaCorrienteTest {
	
	CuentaCorriente cuenta1, cuenta2;
	
	@BeforeEach
	void setUp() throws Exception {
		cuenta1 = new CuentaCorriente();
		cuenta2 = new CuentaCorriente();
	}
	
    @Test
    public void testNombreCompleto() {
        assertEquals("Gosling, James", james.getNombreCompleto());
        assertEquals("van Rossum, Guido", guido.getNombreCompleto());
    }
}
