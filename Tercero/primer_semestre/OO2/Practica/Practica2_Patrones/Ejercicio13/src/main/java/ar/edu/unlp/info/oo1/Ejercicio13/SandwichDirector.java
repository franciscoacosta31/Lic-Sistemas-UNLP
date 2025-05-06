package ar.edu.unlp.info.oo1.Ejercicio13;

public class SandwichDirector {

	SandwichBuilder builder;
	
	public SandwichDirector(SandwichBuilder builder) {
		this.builder = builder;
	}
	
	public Sandwich crearSandwich() {
		this.builder.agregarPan();
		this.builder.agregarAderezo();
		this.builder.agregarPrincipal();
		this.builder.agregarAdicional();
		return builder.getProducto();
	}
}
