package ar.edu.unlp.info.oo1.Ejercicio02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoPlantaTest {

	private Empleado empCasadoSinHijos;
    private Empleado empCasadoConHijos;
    private Empleado empSolteroSinHijos;
    private Empleado empSolteroConHijos;
	
	@BeforeEach
	void setUp() throws Exception {
		empCasadoSinHijos = new Planta(true, 0, 1); 
        empCasadoConHijos = new Planta(true, 1, 1);  
        empSolteroSinHijos = new Planta(false, 0, 1);
        empSolteroConHijos = new Planta(false, 1, 1);
	}

	@Test
    public void testSueldoBasico() {
        assertEquals(50000, empCasadoSinHijos.calcularBasico());
        assertEquals(50000, empCasadoConHijos.calcularBasico());
        assertEquals(50000, empSolteroSinHijos.calcularBasico());
        assertEquals(50000, empSolteroConHijos.calcularBasico());
    }

    @Test
    public void testCalcularAdicionales() {
        assertEquals(7000, empCasadoSinHijos.calcularAdicional()); 
        assertEquals(9000, empCasadoConHijos.calcularAdicional());
        assertEquals(2000, empSolteroSinHijos.calcularAdicional());
        assertEquals(4000, empSolteroConHijos.calcularAdicional());
    }

    @Test
    public void testCalcularDescuentos() {
        assertEquals(6850, empCasadoSinHijos.calcularDescuento()); 
        assertEquals(6950, empCasadoConHijos.calcularDescuento());  
        assertEquals(6600, empSolteroSinHijos.calcularDescuento());
        assertEquals(6700, empSolteroConHijos.calcularDescuento()); 
    }

    @Test
    public void testSueldo() {
        assertEquals(50150, empCasadoSinHijos.calcularSueldoTotal());  
        assertEquals(52050, empCasadoConHijos.calcularSueldoTotal());  
        assertEquals(45400, empSolteroSinHijos.calcularSueldoTotal()); 
        assertEquals(47300, empSolteroConHijos.calcularSueldoTotal());
    }
}
