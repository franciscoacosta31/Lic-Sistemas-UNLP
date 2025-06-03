package ar.edu.unlp.info.oo1.Ejercicio05;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecodificadorTest {

	private Decodificador decodificador;
	private List<Pelicula> peliculas;
	private List<Pelicula> reproducidas;
	Pelicula pelicula1;
	Pelicula pelicula2;
	Pelicula pelicula3;
	Pelicula pelicula4;
	Pelicula pelicula5;
	Pelicula pelicula6;
	Pelicula pelicula7;
	Pelicula pelicula8;
	Pelicula pelicula9;
	Pelicula pelicula10;
	
	
	@BeforeEach
	void setUp() throws Exception {
		pelicula1 = new Pelicula("El Padrino", 1972, 92);
        pelicula2 = new Pelicula("Titanic", 1997, 78);
        pelicula3 = new Pelicula("Avatar", 2009, 78);
        pelicula4 = new Pelicula("Pulp Fiction", 1994, 91);
        pelicula5 = new Pelicula("Forrest Gump", 1994, 88);
        pelicula6 = new Pelicula("El Senior de los Anillos: El Retorno del Rey", 2003, 90);
        pelicula7 = new Pelicula("La lista de Schindler", 1993, 89);
        pelicula8 = new Pelicula("Matrix", 1999, 87);
        pelicula9 = new Pelicula("Interestelar", 2014, 86);
        pelicula10 = new Pelicula("Gladiador", 2000, 85);
        
        pelicula3.agregarSimilar(pelicula6);
        pelicula3.agregarSimilar(pelicula9);
        pelicula1.agregarSimilar(pelicula4);
        pelicula1.agregarSimilar(pelicula10);
        pelicula7.agregarSimilar(pelicula5);
        
        peliculas = new ArrayList<Pelicula>();
        reproducidas = new ArrayList<Pelicula>();
        
        peliculas.add(pelicula1);
        peliculas.add(pelicula2);
        peliculas.add(pelicula3);
        peliculas.add(pelicula4);
        peliculas.add(pelicula5);
        peliculas.add(pelicula6);
        peliculas.add(pelicula7);
        peliculas.add(pelicula8);
        peliculas.add(pelicula9);
        peliculas.add(pelicula10);
        
        reproducidas.add(pelicula1);
        reproducidas.add(pelicula3);
        reproducidas.add(pelicula5);
        reproducidas.add(pelicula7);
        
        decodificador = new Decodificador(peliculas, reproducidas);
	}

	@Test
	void testObtenerSugerenciaPorSimilaridad() {
		decodificador.setEstrategia(new Similaridad());
		List<Pelicula> similares = decodificador.sugerirPeliculas();
		
		assertTrue(similares.contains(pelicula6));
		assertTrue(similares.contains(pelicula10));
		assertTrue(similares.contains(pelicula9));
	}

	@Test
	void testObtenerSugerenciasPorPuntaje() {
		decodificador.setEstrategia(new Puntaje());
		List<Pelicula> puntaje = decodificador.sugerirPeliculas();
		
		assertTrue(puntaje.contains(pelicula1));
		assertTrue(puntaje.contains(pelicula4));
		assertTrue(puntaje.contains(pelicula6));
	}
}
