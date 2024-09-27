package ar.edu.unlp.info.oo1.ejercicio2;

import java.util.ArrayList;
import java.util.List;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Balanza {

	private List<Producto> productos = new ArrayList<Producto>();

	
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public void ponerEnCero() {
		this.productos.clear();
	}
	
	public Ticket emitirTicket() {
		Ticket t = new Ticket(productos);
		return t;
	}

	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public double getPesoTotal() {
		double pesoTotal = 0.0;
		for(Producto p: productos) {
			pesoTotal += p.getPeso();
		}
		return pesoTotal;
	}

	public double getPrecioTotal() {
		double precioTotal = 0.0;
		for(Producto p: productos) {
			precioTotal += p.getPrecio();
		}
		return precioTotal;
	}

	public int getCantidadDeProductos() {
		return this.productos.size();
	}
	
}
