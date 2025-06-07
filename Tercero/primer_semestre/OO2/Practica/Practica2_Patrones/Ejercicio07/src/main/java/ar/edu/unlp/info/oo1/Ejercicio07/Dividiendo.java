package ar.edu.unlp.info.oo1.Ejercicio07;

public class Dividiendo extends Estado {

	public Dividiendo(Calculadora context, double valor) {
		super(context, valor);
	}

	@Override
	public void setValor(double valor) {
		if (valor == 0.0) {
			this.getContext().setState(new Error(this.getContext()));
		} else {
			this.setValorAcumulado(this.getValorAcumulado() / valor);
			this.getContext().setState(new Esperando(this.getContext(), this.getValorAcumulado()));
		}
	}
}
