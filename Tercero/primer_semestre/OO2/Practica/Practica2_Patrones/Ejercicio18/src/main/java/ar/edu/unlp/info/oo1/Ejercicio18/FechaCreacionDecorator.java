package ar.edu.unlp.info.oo1.Ejercicio18;

public class FechaCreacionDecorator extends Decorator {

	public FechaCreacionDecorator(FileOO2Interface component) {
		super(component);
	}

	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.getFechaCreacion();
	}
}
