package ar.edu.unlp.info.oo1.Ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SandwichDirectorTest {

	private SandwichDirector director1;
	private SandwichDirector director2;
	private SandwichDirector director3;
	private SandwichDirector director4;
	private SandwichBuilder clasicoBuilder;
	private SandwichBuilder vegetarianoBuilder;
	private SandwichBuilder veganoBuilder;
	private SandwichBuilder sinTACCBuilder;
	
	@BeforeEach
	void setUp() throws Exception {
		clasicoBuilder = new ClasicoBuilder();
		vegetarianoBuilder = new VegetarianoBuilder();
		veganoBuilder = new VeganoBuilder();
		sinTACCBuilder = new SinTACCBuilder();
		director1 = new SandwichDirector(clasicoBuilder);
		director2 = new SandwichDirector(vegetarianoBuilder);
		director3 = new SandwichDirector(veganoBuilder);
		director4 = new SandwichDirector(sinTACCBuilder);
	}

	@Test
	void testCrearSandwich() {
		assertEquals(director1.crearSandwich().getPrecioTotal(), 500);
		assertEquals(director2.crearSandwich().getPrecioTotal(), 420);
		assertEquals(director3.crearSandwich().getPrecioTotal(), 620);
		assertEquals(director4.crearSandwich().getPrecioTotal(), 618);
	}
}
