package ar.edu.unlp.info.oo1.Ejercicio11;

import java.util.*;

public class Mixta extends Topografia {

	private List<Topografia> partes;
	
	public Mixta(List<Topografia> partes) {
		this.partes = partes;
	}
	
	public double calcularProporcion() {
		return partes.stream().mapToDouble(partes->partes.calcularProporcion()).sum()/4;
	}
	
	public boolean esIgual(Topografia otro) {
		if (otro.calcularProporcion() == 0 || otro.calcularProporcion() == 1) {
			return false;
		}
		else {
			return esIgualHelper((Mixta) otro);
		}
	}
	
	private boolean esIgualHelper(Mixta otro) {
		for (int i = 0; i < 4; i++) {
			if (this.partes.get(i).calcularProporcion() != otro.getPartes().get(i).calcularProporcion()) {
				return false;
			}
		}
		return true;
	}
	
	public List<Topografia> getPartes(){
		return this.partes;
	}
	
}
