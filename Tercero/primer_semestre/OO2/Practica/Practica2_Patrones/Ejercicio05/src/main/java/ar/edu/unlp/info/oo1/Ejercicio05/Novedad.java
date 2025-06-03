package ar.edu.unlp.info.oo1.Ejercicio05;

import java.util.*;
import java.util.stream.*;

public class Novedad implements Mecanismo {
	
	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
		return decodificador.getPeliculas().stream()
				.sorted((ex1, ex2) -> Integer.compare(ex2.getAñoEstreno(), ex1.getAñoEstreno()))
				.limit(3)
				.collect(Collectors.toList());
	}
}
