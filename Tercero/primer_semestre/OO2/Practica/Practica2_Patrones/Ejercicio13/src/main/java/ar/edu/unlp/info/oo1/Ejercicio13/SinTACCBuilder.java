package ar.edu.unlp.info.oo1.Ejercicio13;

public class SinTACCBuilder extends SandwichBuilder {

	@Override
	public void agregarPan() {
		this.getProducto().setPan("Pan de chipá");
		this.getProducto().setPrecioPan(150);
	}

	@Override
	public void agregarAderezo() {
		this.getProducto().setAderezo("Salsa tártara");
		this.getProducto().setPrecioAderezo(18);
	}

	@Override
	public void agregarPrincipal() {
		this.getProducto().setPrincipal("Carne de pollo");
		this.getProducto().setPrecioPrincipal(250);
	}

	@Override
	public void agregarAdicional() {
		this.getProducto().setAdicional("Verduras grilladas");
		this.getProducto().setPrecioAdicional(200);
	}
}
