package ar.edu.unlp.info.oo1.Ejercicio07;

public class Multiplicando extends Estado {

	public Multiplicando(Calculadora context, double valor) {
		super(context, valor);
	}

	@Override
	public void setValor(double valor) {
		this.setValorAcumulado(this.getValorAcumulado() * valor);
		this.getContext().setState(new Esperando(this.getContext(), this.getValorAcumulado()));
	}
}
