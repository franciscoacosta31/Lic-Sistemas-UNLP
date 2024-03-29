package ejercicio3;

public class Estudiante extends Persona{
	private String comision;
	private String direccion;
	public String getComision() {
		return comision;
	}
	public void setComision(String comision) {
		this.comision = comision;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String tusDatos() {
		String aux = super.tusDatos();
		aux += " Comision: "+this.getComision();
		aux += " Direccion: "+this.getDireccion();
		aux += "\n";
		return aux;
	}
}
