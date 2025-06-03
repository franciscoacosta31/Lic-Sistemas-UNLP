package ar.edu.unlp.info.oo1.Ejercicio05;

import java.util.*;

public class Decodificador {

	private List<Pelicula> peliculas;
	private List<Pelicula> peliculasReproducidas;
	private Mecanismo estrategia;
	
	public Decodificador(List<Pelicula> peliculas, List<Pelicula> reproducidas) {
		this.peliculas = peliculas;
		this.peliculasReproducidas = reproducidas;
	}
	
	public List<Pelicula> sugerirPeliculas(){
		return this.estrategia.sugerirPeliculas(this);
	}
	
	public void agregarPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}
	
	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}
	
	public List<Pelicula> getPeliculasReproducidas() {
		return this.peliculasReproducidas;
	}
	
	public void setEstrategia(Mecanismo estrategia) {
		this.estrategia = estrategia;
	}
}
