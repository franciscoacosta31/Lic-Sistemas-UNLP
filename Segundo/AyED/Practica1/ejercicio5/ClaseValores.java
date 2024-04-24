package ejercicio5;

public class ClaseValores {
	private int min;
	private int max;
	private float prom;
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public float getProm() {
		return prom;
	}
	public void setProm(float prom) {
		this.prom = prom;
	}
	public String toString() {
		String aux = "";
		aux += "Max:"+this.getMax()+
				" Min:"+this.getMin()+
				" Promedio:"+this.getProm();
		
		return aux; 
	}
}
