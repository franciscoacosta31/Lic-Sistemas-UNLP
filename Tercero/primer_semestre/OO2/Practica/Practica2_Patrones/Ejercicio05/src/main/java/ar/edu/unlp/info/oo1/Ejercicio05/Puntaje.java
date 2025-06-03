package ar.edu.unlp.info.oo1.Ejercicio05;

import java.util.List;
import java.util.stream.Collectors;

public class Puntaje implements Mecanismo {

	@Override
	public List<Pelicula> sugerirPeliculas(Decodificador decodificador) {
		return decodificador.getPeliculas().stream()
				.sorted((x1, x2) -> Integer.compare(x2.getPuntaje(), x1.getPuntaje()))
				.limit(3)
				.collect(Collectors.toList());
	}

}
