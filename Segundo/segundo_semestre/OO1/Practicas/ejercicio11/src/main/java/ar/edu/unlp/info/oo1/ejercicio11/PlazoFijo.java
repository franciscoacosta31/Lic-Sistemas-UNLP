package ar.edu.unlp.info.oo1.ejercicio11;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo implements Inversion{

	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public double valorActual() {
		return montoDepositado + porcentajeDeInteresDiario * ChronoUnit.DAYS.between(fechaDeConstitucion, LocalDate.now());
	}
}
