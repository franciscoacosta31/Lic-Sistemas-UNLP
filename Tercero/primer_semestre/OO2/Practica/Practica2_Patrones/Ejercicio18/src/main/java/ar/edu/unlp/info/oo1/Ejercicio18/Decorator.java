package ar.edu.unlp.info.oo1.Ejercicio18;

import java.time.LocalDate;

public abstract class Decorator implements FileOO2Interface{

	private FileOO2Interface componente;
	
	public Decorator(FileOO2Interface component) {
		this.componente = component;
	}
	
	public String prettyPrint() {
		return this.componente.prettyPrint();
	}
	
	public String getExtension() {
		return componente.getExtension();
	}
	
	public String getTamaño() {
		return componente.getTamaño();
	}

	public LocalDate getFechaCreacion() {
		return componente.getFechaCreacion();
	}

	public LocalDate getFechaModificacion() {
		return componente.getFechaModificacion();
	}

	public String getPermisos() {
		return componente.getPermisos();
	}
}
