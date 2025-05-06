package ar.edu.unlp.info.oo1.Ejercicio18;

public class PermisosDecorator extends Decorator {

	public PermisosDecorator(FileOO2Interface component) {
		super(component);
	}

	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.getPermisos();
	}
}
