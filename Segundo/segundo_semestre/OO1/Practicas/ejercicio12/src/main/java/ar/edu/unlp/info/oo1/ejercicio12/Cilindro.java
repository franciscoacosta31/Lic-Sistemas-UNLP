package ar.edu.unlp.info.oo1.ejercicio12;

public class Cilindro extends Pieza{

	private int radio;
	private int altura;
	
	public Cilindro(int radio, int altura) {
		this.radio = radio;
		this.altura = altura;
	}
	
	public double getVolumen() {
		return Math.PI * this.radio * this.radio * altura; 
	}
	
	public double getSuperficie() {
		return 2 * Math.PI * this.radio * this.altura + 
				2 * Math.PI * this.radio * this.radio;
	}
}
