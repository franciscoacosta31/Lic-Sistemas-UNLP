package ar.edu.unlp.info.oo1.Ejercicio05;

import java.util.*;

public class Pelicula {
	private String titulo;
	private int añoEstreno;
	private int puntaje;
	private List<Pelicula> peliculasSimilares;
	
	public Pelicula(String titulo, int añoEstreno, int puntaje) {
		this.titulo = titulo;
		this.añoEstreno = añoEstreno;
		this.puntaje = puntaje;
		this.peliculasSimilares = new ArrayList<Pelicula>();
	}
	
	public int getAñoEstreno() {
		return this.añoEstreno;
	}
	
	public List<Pelicula> getSimilares() {
		return this.peliculasSimilares;
	}
	
	public int getPuntaje() {
		return this.puntaje;
	}
	
	public void agregarSimilar(Pelicula peliculaSimilar) {
		this.peliculasSimilares.add(peliculaSimilar);
	}
}
