package ejercicio7;

public class Estudiante {
	private String nombre;
	private int legajo;
	
	public Estudiante (String nombre,int legajo) {
		this.nombre = nombre;
		this.legajo = legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public String toString() {
		String aux = "Nombre: "+this.getNombre()+" Legajo: "+this.getLegajo();
		return aux;
	}
	
}
