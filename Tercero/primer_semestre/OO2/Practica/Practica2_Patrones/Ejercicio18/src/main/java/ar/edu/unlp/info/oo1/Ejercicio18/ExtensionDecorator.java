package ar.edu.unlp.info.oo1.Ejercicio18;

public class ExtensionDecorator extends Decorator {

	public ExtensionDecorator(FileOO2Interface component) {
		super(component);
	}

	public String prettyPrint() {
		return super.prettyPrint() + " - " + this.getExtension();
	}
}
