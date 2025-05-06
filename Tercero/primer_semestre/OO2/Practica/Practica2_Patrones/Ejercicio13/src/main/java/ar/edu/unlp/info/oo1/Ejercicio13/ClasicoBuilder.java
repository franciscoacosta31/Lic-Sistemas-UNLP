package ar.edu.unlp.info.oo1.Ejercicio13;

public class ClasicoBuilder extends SandwichBuilder {

	@Override
	public void agregarPan() {
		this.getProducto().setPan("Pan brioche");
		this.getProducto().setPrecioPan(100);
	}

	@Override
	public void agregarAderezo() {
		this.getProducto().setAderezo("Aderezo a base de mayonesa");
		this.getProducto().setPrecioAderezo(20);
	}

	@Override
	public void agregarPrincipal() {
		this.getProducto().setPrincipal("Carne de ternera");
		this.getProducto().setPrecioPrincipal(300);
	}

	@Override
	public void agregarAdicional() {
		this.getProducto().setAdicional("Tomate");
		this.getProducto().setPrecioAdicional(80);
	}
}
