package ar.edu.unlp.info.oo1.Ejercicio02;

public abstract class Empleado {

	public int calcularSueldoTotal() {
		return this.calcularBasico() + this.calcularAdicional() - this.calcularDescuento();
	}
	
	public int calcularDescuento() {
		return (int) (this.calcularBasico() * 0.13 + this.calcularAdicional() * 0.05);
	}
	
	public abstract int calcularBasico();
	public abstract int calcularAdicional();
}
