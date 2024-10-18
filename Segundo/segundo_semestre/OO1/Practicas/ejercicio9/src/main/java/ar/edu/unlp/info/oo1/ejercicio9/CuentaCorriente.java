package ar.edu.unlp.info.oo1.ejercicio9;

public class CuentaCorriente extends Cuenta {

	private double descubierto;
	
	public CuentaCorriente() {
		this.descubierto = 0;
	}
	
	public double getDescubierto() {
		return this.descubierto;
	}
	
	public void setDescubierto(double descubierto) {
		this.descubierto = descubierto;
	}
	
	protected boolean puedeExtraer(double monto) {
		if (super.getSaldo() - monto > this.descubierto) {
			return true;
		}
		return false;
	}
}
