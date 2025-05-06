package ar.edu.unlp.info.oo1.Ejercicio18;

import java.time.LocalDate;

public class FileOO2 implements FileOO2Interface {
	
	private String nombre;
	private String extension;
	private String tamaño;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private String permisos;
	
	public FileOO2(String nombre, String extension, String tamaño, LocalDate fechaCreacion, LocalDate fechaModificacion, String permisos) {
		this.nombre = nombre;
		this.extension = extension;
		this.tamaño = tamaño;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.permisos = permisos;
	}
	
	public String prettyPrint() {
		return this.getNombre();
	}

	public String getNombre() {
		return nombre;
	}


	public String getExtension() {
		return extension;
	}


	public String getTamaño() {
		return tamaño;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public LocalDate getFechaModificacion() {
		return fechaModificacion;
	}


	public String getPermisos() {
		return permisos;
	}
	
}
