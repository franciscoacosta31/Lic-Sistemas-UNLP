package ar.edu.unlp.info.oo1.ejercicio81;

public class Gerente extends Empleadojerarquico {

	public double aportes() {
		return this.montoBasico() * 0.05;
	}
	
	public double montoBasico() {
		return 57000;
	}
}
