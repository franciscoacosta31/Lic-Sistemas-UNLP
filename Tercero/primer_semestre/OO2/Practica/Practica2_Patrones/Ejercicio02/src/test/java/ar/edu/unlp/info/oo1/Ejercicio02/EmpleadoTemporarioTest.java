package ar.edu.unlp.info.oo1.Ejercicio02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoTemporarioTest {

	private Empleado empCasadoSinHijos;
	private Empleado empCasadoConHijos;
	private Empleado empSolteroConHijos;
	private Empleado empSolteroSinHijos;
	
	@BeforeEach
	void setUp() throws Exception {
		empCasadoSinHijos = new Temporario(1, 0, true);
		empCasadoConHijos = new Temporario(1, 1, true);
		empSolteroConHijos = new Temporario(1, 1, false);
		empSolteroSinHijos = new Temporario (1, 0, false);
	}

	@Test
	public void testSueldoBasico() {
		assertEquals(20300, empCasadoSinHijos.calcularBasico());
		assertEquals(20300, empCasadoConHijos.calcularBasico());
		assertEquals(20300, empSolteroSinHijos.calcularBasico());
		assertEquals(20300, empSolteroConHijos.calcularBasico());
	}
	
	@Test
	public void testCalcularAdicionales() {
		assertEquals(5000, empCasadoSinHijos.calcularAdicional());
		assertEquals(7000, empCasadoConHijos.calcularAdicional());
		assertEquals(0, empSolteroSinHijos.calcularAdicional());
		assertEquals(2000, empSolteroConHijos.calcularAdicional());
	}
	
	@Test
	public void testCalcularDescuentos() {
	    assertEquals(2889, empCasadoSinHijos.calcularDescuento());
	    assertEquals(2989, empCasadoConHijos.calcularDescuento());
	    assertEquals(2639, empSolteroSinHijos.calcularDescuento());
	    assertEquals(2739, empSolteroConHijos.calcularDescuento());
	}

	@Test
	public void sueldo() {
	    assertEquals(22411, empCasadoSinHijos.calcularSueldoTotal());
	    assertEquals(24311, empCasadoConHijos.calcularSueldoTotal());
	    assertEquals(17661, empSolteroSinHijos.calcularSueldoTotal());
	    assertEquals(19561, empSolteroConHijos.calcularSueldoTotal());
	}

}
