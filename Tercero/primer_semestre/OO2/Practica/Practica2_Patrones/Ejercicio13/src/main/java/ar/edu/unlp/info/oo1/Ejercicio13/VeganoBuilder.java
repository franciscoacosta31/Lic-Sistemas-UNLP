package ar.edu.unlp.info.oo1.Ejercicio13;

public class VeganoBuilder extends SandwichBuilder {
	@Override
	public void agregarPan() {
		this.getProducto().setPan("Pan integral");
		this.getProducto().setPrecioPan(100);
	}

	@Override
	public void agregarAderezo() {
		this.getProducto().setAderezo("Salsa Criolla");
		this.getProducto().setPrecioAderezo(20);
	}

	@Override
	public void agregarPrincipal() {
		this.getProducto().setPrincipal("Milanesa de girgolas");
		this.getProducto().setPrecioPrincipal(500);
	}

	@Override
	public void agregarAdicional() {
		this.getProducto().setAdicional("");
		this.getProducto().setPrecioAdicional(0);
	}
}
