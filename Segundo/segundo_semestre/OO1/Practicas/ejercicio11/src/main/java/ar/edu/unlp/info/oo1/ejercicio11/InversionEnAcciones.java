package ar.edu.unlp.info.oo1.ejercicio11;

public class InversionEnAcciones implements Inversion{

	private String nombre;
	private int cantidad = 0;
	private double valorUnitario = 0.0;
	
	public double valorActual() {
		return cantidad * valorUnitario;
	}
}
