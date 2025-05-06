package ar.edu.unlp.info.oo1.Ejercicio11;

public class Agua extends Topografia {

	public double calcularProporcion() {
		return 1;
	}
	
	public boolean esIgual(Topografia otro) {
		if (otro.calcularProporcion() == 1)
			return true;
		return false;
	}
}
