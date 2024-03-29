package ejercicio2;
public class vector{
	private int [] vec;
	private int n;
	
	public int[] crearVector(int n) {
		this.n = n;
		this.vec = new int[n];
		for(int i = 0;i<n;i++){
			this.vec[i] = n * (i+1);
		}
		return vec;
	}
	public String toString() {
		String cadena = "";
		for (int i=0;i<n;i++) {
			cadena += vec[i] + "-";
		}
		return cadena;
	}
}
