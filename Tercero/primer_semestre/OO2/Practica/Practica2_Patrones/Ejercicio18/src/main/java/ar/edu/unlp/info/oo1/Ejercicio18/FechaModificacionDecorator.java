package ar.edu.unlp.info.oo1.Ejercicio18;

public class FechaModificacionDecorator extends Decorator {
	
	public FechaModificacionDecorator(FileOO2Interface component) {
		super(component);
	}

	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.getFechaModificacion();
	}
}
