package ejercicio3;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String Email;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String mail) {
		this.Email = mail;
	}
	
	public String tusDatos(){
		String aux = "";
		aux += " Nombre: "+this.getNombre();
		aux += " Apellido: "+this.getApellido();
		aux += " Email: " +this.getEmail();
		return aux;
	}
}
