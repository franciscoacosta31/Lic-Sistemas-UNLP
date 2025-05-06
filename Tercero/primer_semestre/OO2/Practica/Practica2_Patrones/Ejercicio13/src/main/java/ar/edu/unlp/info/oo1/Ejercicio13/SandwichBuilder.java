package ar.edu.unlp.info.oo1.Ejercicio13;

public abstract class SandwichBuilder {
	
	private Sandwich producto;
	
	public SandwichBuilder() {
		this.producto = new Sandwich();
	}
	
	public abstract void agregarPan();
	public abstract void agregarAderezo();
	public abstract void agregarPrincipal();
	public abstract void agregarAdicional();
	
	public Sandwich getProducto() {
		return this.producto;
	}
}
