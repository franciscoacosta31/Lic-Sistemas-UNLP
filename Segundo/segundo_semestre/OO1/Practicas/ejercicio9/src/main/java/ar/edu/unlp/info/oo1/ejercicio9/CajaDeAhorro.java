package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta{

	public CajaDeAhorro() {
		super();
	}
	
	protected boolean puedeExtraer(double monto) {
		monto = monto * 1.02;
		if (super.getSaldo() >= monto) { 
			return true;
		}
		return false;
	}
}
