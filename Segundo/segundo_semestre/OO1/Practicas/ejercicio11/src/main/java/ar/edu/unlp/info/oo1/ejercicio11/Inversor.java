package ar.edu.unlp.info.oo1.ejercicio11;
import java.util.List;

public class Inversor {

	String nombre;
	List<Inversion> inversiones;
	
	public double valorActual() {
		return inversiones.stream()
			.mapToDouble(inversion->inversion.valorActual())
			.sum();
	}
}
