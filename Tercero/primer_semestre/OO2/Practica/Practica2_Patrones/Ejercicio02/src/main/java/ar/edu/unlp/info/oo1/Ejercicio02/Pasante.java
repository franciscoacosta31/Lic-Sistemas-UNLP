package ar.edu.unlp.info.oo1.Ejercicio02;

public class Pasante extends Empleado {
	
	private int cantidadExamenes;

	public Pasante(int cantidadExamenes) {
		this.cantidadExamenes = cantidadExamenes;
	}
	
	@Override
	public int calcularBasico() {
		return 20000;
	}

	@Override
	public int calcularAdicional() {
		int adicional = 0;
		for (int i=0; i<this.cantidadExamenes; i++) {
			adicional += 2000;
		}
		return adicional;
	}
}
