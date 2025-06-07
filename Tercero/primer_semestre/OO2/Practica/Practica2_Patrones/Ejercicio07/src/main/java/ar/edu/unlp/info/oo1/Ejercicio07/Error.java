package ar.edu.unlp.info.oo1.Ejercicio07;

public class Error extends Estado {
	
	public Error(Calculadora context) {
		super(context, 0.0);
	}

	@Override
	public String getResultado() {
		return "Error";
	}

	@Override
	public void setValor(double valor) {}
	
}
