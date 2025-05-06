package ar.edu.unlp.info.oo1.Ejercicio13;

public class VegetarianoBuilder extends SandwichBuilder{

	@Override
	public void agregarPan() {
		this.getProducto().setPan("Pan con semillas");
		this.getProducto().setPrecioPan(120);
	}

	@Override
	public void agregarAderezo() {
		this.getProducto().setAderezo("");
		this.getProducto().setPrecioAderezo(0);
	}

	@Override
	public void agregarPrincipal() {
		this.getProducto().setPrincipal("Provoleta Grillada");
		this.getProducto().setPrecioPrincipal(200);
	}

	@Override
	public void agregarAdicional() {
		this.getProducto().setAdicional("Berenjenas al escabeche");
		this.getProducto().setPrecioAdicional(100);
	}
}
