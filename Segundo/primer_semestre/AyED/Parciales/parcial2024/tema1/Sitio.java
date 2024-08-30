package tp5.parcial2024.tema1;

public class Sitio {
	private String nombre;
	private int tiempo;
	
	public Sitio(String nnombre, int ttiempo) {
		this.nombre = nnombre;
		this.tiempo = ttiempo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}
