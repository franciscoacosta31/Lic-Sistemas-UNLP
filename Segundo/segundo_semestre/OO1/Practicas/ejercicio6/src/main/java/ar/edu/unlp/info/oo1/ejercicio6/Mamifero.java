package ar.edu.unlp.info.oo1.ejercicio6;
import java.time.LocalDate;


public class Mamifero {

	private String identificador;
	private String especie;
	private LocalDate fecha;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero() {}
	
	public Mamifero(String id) {
		this.identificador = id;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public LocalDate getFechaNacimiento() {
		return fecha;
	}
	public void setFechaNacimiento(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public Mamifero getPadre() {
		return this.padre;
	}
	
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	
	public Mamifero getMadre() {
		return this.madre;
	}
	
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	
	public Mamifero getAbueloMaterno() {
		if(this.getMadre() != null) 
			return this.getMadre().getPadre();
		else
			return null;
	}
	
	public Mamifero getAbuelaMaterna() {
		if(this.getMadre() != null) 
			return this.getMadre().getMadre();
		else
			return null;
	}
	
	public Mamifero getAbueloPaterno() {
		if(this.getPadre() != null) 
			return this.getPadre().getPadre();
		else
			return null;
	}
	
	public Mamifero getAbuelaPaterna() {
		if(this.getPadre() != null) 
			return this.getPadre().getMadre();
		else
			return null;
	}
	
	public Boolean tieneComoAncestroA(Mamifero unMamifero) {
		return ((this.padre == unMamifero) || (this.madre == unMamifero) 
				|| (this.padre != null && this.padre.tieneComoAncestroA(unMamifero))
				|| (this.madre != null  && this.madre.tieneComoAncestroA(unMamifero)));
	}
	
	
}
