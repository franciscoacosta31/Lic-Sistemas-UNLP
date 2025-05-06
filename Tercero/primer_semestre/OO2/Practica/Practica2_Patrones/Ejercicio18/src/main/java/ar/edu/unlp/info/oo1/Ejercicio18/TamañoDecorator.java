package ar.edu.unlp.info.oo1.Ejercicio18;

public class TamañoDecorator extends Decorator {

	public TamañoDecorator(FileOO2Interface componente) {
		super(componente);
	}
	
	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.getTamaño();
	}
}
