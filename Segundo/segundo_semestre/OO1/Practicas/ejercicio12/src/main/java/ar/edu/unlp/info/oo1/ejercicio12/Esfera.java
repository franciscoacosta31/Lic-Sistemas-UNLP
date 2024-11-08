package ar.edu.unlp.info.oo1.ejercicio12;

public class Esfera extends Pieza{

	private int radio;
	
	public Esfera(int radio) {
		this.radio = radio;
	}
	
	public double getVolumen() {
		return 4/3 * Math.PI * this.radio * this.radio * this.radio;
	}
	
	public double getSuperficie() {
		return 4 * Math.PI * this.radio * this.radio;
	}
}
