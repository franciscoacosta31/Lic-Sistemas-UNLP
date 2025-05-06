package ar.edu.unlp.info.oo1.Ejercicio13;

public class Sandwich {

	private String pan;
	private int precioPan;
	private String aderezo;
	private int precioAderezo;
	private String principal;
	private int precioPrincipal;
	private String adicional;
	private int precioAdicional;
	
	public int getPrecioTotal() {
		return this.precioPan + this.precioAderezo + this.precioPrincipal + this.precioAdicional;
	}
	
	public void setPan(String pan) {
		this.pan = pan;
	}
	public void setPrecioPan(int precioPan) {
		this.precioPan = precioPan;
	}
	public void setAderezo(String aderezo) {
		this.aderezo = aderezo;
	}
	public void setPrecioAderezo(int precioAderezo) {
		this.precioAderezo = precioAderezo;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public void setPrecioPrincipal(int precioPrincipal) {
		this.precioPrincipal = precioPrincipal;
	}
	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}
	public void setPrecioAdicional(int precioAdicional) {
		this.precioAdicional = precioAdicional;
	}
}
