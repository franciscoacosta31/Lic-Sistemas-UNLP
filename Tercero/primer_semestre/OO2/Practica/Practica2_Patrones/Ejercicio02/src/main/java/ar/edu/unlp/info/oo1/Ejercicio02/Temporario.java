package ar.edu.unlp.info.oo1.Ejercicio02;

public class Temporario extends Empleado {

	private int cantidadHoras;
	private boolean estaCasado;
	private int cantidadHijos;
	
	public Temporario(int cantidadHoras, int cantidadHijos, boolean estaCasado) {
		this.cantidadHoras = cantidadHoras;
		this.estaCasado = estaCasado;
		this.cantidadHijos = cantidadHijos;
	}
	
	@Override
	public int calcularBasico() {
		return 20000 + (this.cantidadHoras * 300);
	}

	@Override
	public int calcularAdicional() {
		int adicional = 0;
		if(estaCasado) {
			adicional += 5000;
		}
		for(int i = 0; i<this.cantidadHijos; i++) {
			adicional += 2000;
		}
		return adicional;
	}
}
