package ar.edu.unlp.info.oo1.Ejercicio07;

public class Calculadora {

	private Estado state;
	
	public Calculadora() {
		this.state = new Esperando(this, 0.0);
	}
	
	public String getResultado() {
		return state.getResultado();
	}
	
	public void borrar() {
		this.state.borrar();
	}
	public void setValor(double valor) {
		this.state.setValor(valor);
	}
	public void mas() {
		this.state.mas();
	}
	public void menos() {
		this.state.menos();
	}
	public void por() {
		this.state.por();
	}
	public void dividido() {
		this.state.dividido();
	}
	
	public void setState(Estado state) {
		this.state = state;
	}
}
