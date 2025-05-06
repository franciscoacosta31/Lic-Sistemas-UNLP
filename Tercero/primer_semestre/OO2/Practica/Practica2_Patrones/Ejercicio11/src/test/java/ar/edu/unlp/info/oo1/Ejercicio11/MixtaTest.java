package ar.edu.unlp.info.oo1.Ejercicio11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MixtaTest {

	private Mixta mixta1;
	private Mixta mixta2;
	private Mixta mixta3;
	
	@BeforeEach
	void setUp() throws Exception {
		List<Topografia> partes1 = new LinkedList<Topografia>();
		partes1.add(new Agua());
		partes1.add(new Tierra());
		partes1.add(new Tierra());
		partes1.add(new Tierra());
		mixta1 = new Mixta(partes1);
		List<Topografia> partes2 = new LinkedList<Topografia>();
		partes2.add(new Agua());
		partes2.add(new Tierra());
		partes2.add(new Tierra());
		partes2.add(new Agua());
		mixta2 = new Mixta(partes2);
		List<Topografia> partes3 = new LinkedList<Topografia>();
		partes3.add(new Agua());
		partes3.add(new Tierra());
		partes3.add(new Tierra());
		partes3.add(new Tierra());
		mixta3 = new Mixta(partes3);
	}

	@Test
	void testIgual() {
		assertFalse(this.mixta1.esIgual(mixta2));
		assertTrue(this.mixta1.esIgual(mixta3));
		assertFalse(this.mixta2.esIgual(mixta3));
	}

}
