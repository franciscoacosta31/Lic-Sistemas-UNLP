package ar.edu.unlp.info.oo1.ejercicio81;

public class Empleadojerarquico extends Empleado{

	public double sueldoBasico() {
		return super.sueldoBasico() + this.bonoPorCategoria();
	}
	
	public double montoBasico() {
		return 45000;
	}
	
	public double bonoPorCategoria() {
		return 8000;
	}
}
