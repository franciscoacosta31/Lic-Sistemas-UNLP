package ar.edu.unlp.info.oo1.Ejercicio02;

public class Planta extends Empleado {

	private boolean estaCasado;
	private int cantidadHijos;
	private int añosAntiguedad;
	
	public Planta(boolean estaCasado, int cantidadHijos, int añosAntiguedad) {
		this.estaCasado = estaCasado;
		this.cantidadHijos = cantidadHijos;
		this.añosAntiguedad = añosAntiguedad;
	}
	
	@Override
	public int calcularBasico() {
		return 50000;
	}

	@Override
	public int calcularAdicional() {
		int adicional = 0;
		int i;
		if (estaCasado) {
			adicional += 5000;
		}
		for (i = 0; i<this.cantidadHijos; i++) {
			adicional += 2000;
		}
		for (i = 0; i<this.añosAntiguedad; i++) {
			adicional += 2000;
		}
		return adicional;
	}

}
