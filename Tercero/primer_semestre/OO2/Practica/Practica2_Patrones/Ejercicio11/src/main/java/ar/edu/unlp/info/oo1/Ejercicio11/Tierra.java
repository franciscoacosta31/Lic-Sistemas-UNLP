package ar.edu.unlp.info.oo1.Ejercicio11;

public class Tierra extends Topografia {

	public double calcularProporcion() {
		return 0;
	}
	
	public boolean esIgual(Topografia otro) {
		if (otro.calcularProporcion() == 0)
			return true;
		return false;
	}
}
