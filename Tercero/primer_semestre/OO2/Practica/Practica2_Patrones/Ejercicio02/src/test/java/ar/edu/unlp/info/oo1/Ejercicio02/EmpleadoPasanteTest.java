package ar.edu.unlp.info.oo1.Ejercicio02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpleadoPasanteTest {

	private Empleado empSinExamenes;
	private Empleado empConUnExamen;
	private Empleado empConDosExamenes;
	
	@BeforeEach
	void setUp() throws Exception {
		empSinExamenes = new Pasante(0);
		empConUnExamen = new Pasante(1);
		empConDosExamenes = new Pasante(2);
	}	

	@Test
    public void testSueldoBasico() {
        assertEquals(20000, empSinExamenes.calcularBasico());
        assertEquals(20000, empConUnExamen.calcularBasico());
        assertEquals(20000, empConDosExamenes.calcularBasico());
    }

    @Test
    public void testCalcularAdicionales() {
        assertEquals(0, empSinExamenes.calcularAdicional());   
        assertEquals(2000, empConUnExamen.calcularAdicional());
        assertEquals(4000, empConDosExamenes.calcularAdicional()); 
    }

    @Test
    public void testCalcularDescuentos() {
        assertEquals(2600, empSinExamenes.calcularDescuento());   
        assertEquals(2700, empConUnExamen.calcularDescuento());  
        assertEquals(2800, empConDosExamenes.calcularDescuento());
    }

    @Test
    public void testSueldo() {
        assertEquals(17400, empSinExamenes.calcularSueldoTotal());   
        assertEquals(19300, empConUnExamen.calcularSueldoTotal());    
        assertEquals(21200, empConDosExamenes.calcularSueldoTotal()); 
    }
}
