package ar.edu.unlp.info.oo1.Ejercicio07;

public abstract class Estado {

	private Calculadora context;
	private double valorAcumulado;
	
	public Estado(Calculadora context, double valor) {
		this.context = context;
		this.valorAcumulado = valor;
	}
	
	public String getResultado() {
		this.context.setState(new Error(this.context));
		return "Error";
	}
	
	public abstract void setValor(double valor);
	
	public double getValorAcumulado() {
		return this.valorAcumulado;
	}
	
	public Calculadora getContext() {
		return this.context;
	}
	
	public void setValorAcumulado(double valor) {
		this.valorAcumulado = valor;
	}
	
	public void borrar() {
		this.context.setState(new Esperando(this.context, 0.0));
	}
	
	public void mas() {
		this.context.setState(new Error(this.context));
	}
	public void menos() {
		this.context.setState(new Error(this.context));
	}
	public void por() {
		this.context.setState(new Error(this.context));
	}
	public void dividido() {
		this.context.setState(new Error(this.context));
	}
}
