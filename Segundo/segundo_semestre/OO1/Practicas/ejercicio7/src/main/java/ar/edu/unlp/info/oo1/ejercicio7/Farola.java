package ar.edu.unlp.info.oo1.ejercicio7;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BooleanSupplier;


public class Farola {

	private boolean on;
	private List<Farola> neighbors;
	
	// Crear una farola. Debe inicializarla como apagada
	public Farola() {
		this.on = false;
		this.neighbors = new LinkedList<Farola>();
	}
	
	/*
	* Crea la relación de vecinos entre las farolas. La 
	* relación de vecinos entre las farolas es recíproca, 
	* es decir el receptor del mensaje será vecino de otraFarola, 
	* al igual que otraFarola también se convertirá en vecina 
	* del receptor del mensaje
	*/
	public void pairWithNeighbor(Farola otraFarola) {
		if(!neighbors.contains(otraFarola)) {
			this.neighbors.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	/*
	* Retorna sus farolas vecinas
	*/
	public List<Farola> getNeighbors(){
		return this.neighbors;
	}


	/*
	* Si la farola no está encendida, la enciende y propaga la acción.
	*/
	public void turnOn() {
		if (!this.on) {
			this.on = true;
			for (Farola f: this.neighbors) {
				f.turnOn();
			}
		}
	}

	/*
	* Si la farola no está apagada, la apaga y propaga la acción.
	*/
	public void turnOff() {
		if (this.on) {
			this.on = false;
			for (Farola f: this.neighbors) {
				f.turnOff();
			}
		}
	}

	/*
	* Retorna true si la farola está encendida.
	*/
	public boolean isOn() {
		return this.on;
	}

	public boolean isOff() {
		return !this.on;
	}
}
