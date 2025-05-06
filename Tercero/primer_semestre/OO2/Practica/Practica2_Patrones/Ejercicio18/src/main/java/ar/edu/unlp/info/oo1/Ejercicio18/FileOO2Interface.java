package ar.edu.unlp.info.oo1.Ejercicio18;

import java.time.LocalDate;

public interface FileOO2Interface {

	public String prettyPrint();
	public String getExtension();
	public String getTamaño();
	public LocalDate getFechaCreacion();
	public LocalDate getFechaModificacion();
	public String getPermisos();
}
