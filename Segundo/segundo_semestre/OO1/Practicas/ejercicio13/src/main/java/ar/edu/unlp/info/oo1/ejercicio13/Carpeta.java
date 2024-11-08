package ar.edu.unlp.info.oo1.ejercicio13;
import java.util.*;

public class Carpeta {
	private String nombre;
	private List<Email> emails = new ArrayList<Email>();
	
	public void agregarEmail(Email e) {
		emails.add(e);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void mover(Email email, Carpeta destino) {
		this.emails.remove(email);
		destino.agregarEmail(email);
	}
	
	public Email buscar(String text) {
		return emails.stream().filter(e -> e.contiene(text)).findFirst().orElse(null);
	}
	
	public int espacioOcupado() {
		return emails.stream().mapToInt(e->e.espacioOcupado()).sum();
	}
}
