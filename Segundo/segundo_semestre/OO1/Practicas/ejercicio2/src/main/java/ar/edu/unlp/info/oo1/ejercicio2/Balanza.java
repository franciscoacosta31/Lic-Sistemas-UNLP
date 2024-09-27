package ar.edu.unlp.info.oo1.ejercicio2;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Balanza {

	private double pesoTotal;
	private double precioTotal;
	private int cantidadDeProductos;
	
	public void agregarProducto(Producto producto) {
		this.pesoTotal += producto.getPeso();
		this.precioTotal += producto.getPrecio();
		this.cantidadDeProductos++;
	}
	
	public void ponerEnCero() {
		this.pesoTotal = 0;
		this.precioTotal = 0;
		this.cantidadDeProductos = 0;
	}
	
	public Ticket emitirTicket() {
		Ticket t = new Ticket(cantidadDeProductos, pesoTotal, precioTotal);
		return t;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
}
