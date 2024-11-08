package ar.edu.unlp.info.oo1.ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class ReporteDeConstruccion {
	private List<Pieza> piezas;	
	
	public ReporteDeConstruccion() {
		this.piezas = new ArrayList<Pieza>();
	}
	
	public void agregarPieza(Pieza p) {
		this.piezas.add(p);
	}
	
	public double getVolumenDeMaterial(String material) {
		return this.piezas.stream().filter(Pieza -> Pieza.getMaterial().equals(material))
				.mapToDouble(p -> p.getVolumen()).sum();
	}
	
	public double getSuperficieDeColor(String color) {
		return this.piezas.stream().filter(Pieza -> Pieza.getColor().equals(color))
				.mapToDouble(p -> p.getSuperficie()).sum();
	}
	
}
