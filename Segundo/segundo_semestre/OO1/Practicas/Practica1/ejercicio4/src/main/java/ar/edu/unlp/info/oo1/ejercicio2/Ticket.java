package ar.edu.unlp.info.oo1.ejercicio2;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
	
	private LocalDate fecha;
	private List<Producto> productos;
	
	public Ticket(List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.productos = new ArrayList<Producto>(productos);
	}

	public double impuesto() {
		return this.getPrecioTotal() * 0.21;
	}
	
	public List<Producto> getProductos(){
		return this.productos;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public int getCantidadDeProductos() {
		return productos.size();
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
}
