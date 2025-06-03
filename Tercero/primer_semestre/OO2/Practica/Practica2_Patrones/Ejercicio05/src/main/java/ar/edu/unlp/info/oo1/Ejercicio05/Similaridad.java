package ar.edu.unlp.info.oo1.Ejercicio05;

import java.util.List;
import java.util.stream.Collectors;

public class Similaridad implements Mecanismo {

	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
		return decodificador.getPeliculasReproducidas().stream()
				.flatMap(pelicula -> pelicula.getSimilares().stream())
				.distinct()
				.sorted((p1, p2) -> Integer.compare(p2.getAñoEstreno(), p1.getAñoEstreno()))
				.collect(Collectors.toList());
	}

}
