package ar.edu.unlp.info.oo1.ejercicio13;
import java.util.*;

public class Email {
	public String titulo;
	public String cuerpo;
	public List<Archivo> archivos;
	
	public Email(String titulo, String cuerpo) {
		this.titulo = titulo;
		this.cuerpo = cuerpo;
		this.archivos = new ArrayList<Archivo>();
	}
	
	public void agregarArchivo(Archivo a) {
		archivos.add(a);
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public List<Archivo> adjuntos(){
		return this.archivos;
	}

	public boolean contiene(String text) {
		return this.getTitulo().equals(text) || this.getCuerpo().equals(text);
	}
	
	public int espacioOcupado() {
		int suma = archivos.stream().mapToInt(a->a.tamaño()).sum();
		return this.getTitulo().length() + this.getCuerpo().length() + suma;
	}
}
