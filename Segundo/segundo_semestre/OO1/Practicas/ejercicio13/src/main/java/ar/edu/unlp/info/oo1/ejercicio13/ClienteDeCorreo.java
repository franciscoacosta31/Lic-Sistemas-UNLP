package ar.edu.unlp.info.oo1.ejercicio13;
import java.util.*;

public class ClienteDeCorreo {

	private Carpeta inbox;
	private List<Carpeta> carpetas = new ArrayList<Carpeta>();
	
	public ClienteDeCorreo(Carpeta inbox) {
		this.inbox = inbox;
		this.carpetas = new ArrayList<Carpeta>();
		this.carpetas.add(inbox);
	}
	
	public void agregarCarpeta(Carpeta c) {
		this.carpetas.add(c);
	}
	
	public void recibir(Email email) {
		this.inbox.agregarEmail(email);
	}
	
	public Email buscar(String texto) {
		return carpetas.stream().filter(c->c.buscar(texto) != null).findFirst().orElse(null).buscar(texto);
	}
	
	public int espacioOcupado() {
		return carpetas.stream().mapToInt(a->a.espacioOcupado()).sum();
	}
}
