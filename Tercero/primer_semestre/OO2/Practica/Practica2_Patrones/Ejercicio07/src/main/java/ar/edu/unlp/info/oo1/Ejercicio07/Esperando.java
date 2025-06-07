package ar.edu.unlp.info.oo1.Ejercicio07;

public class Esperando extends Estado {

	public Esperando(Calculadora context, double valor) {
		super(context, valor);
	}
	
	@Override
	public String getResultado() {
		return String.valueOf(this.getValorAcumulado());
	}

	@Override
	public void setValor(double valor) {
		this.setValorAcumulado(valor);
	}	
	
	@Override
	public void mas() {
		this.getContext().setState(new Sumando(this.getContext(), this.getValorAcumulado()));
	}
	@Override
	public void menos() {
		this.getContext().setState(new Restando(this.getContext(), this.getValorAcumulado()));
	}
	@Override
	public void por() {
		this.getContext().setState(new Multiplicando(this.getContext(), this.getValorAcumulado()));
	}
	@Override
	public void dividido() {
		this.getContext().setState(new Dividiendo(this.getContext(), this.getValorAcumulado()));
	}
}
