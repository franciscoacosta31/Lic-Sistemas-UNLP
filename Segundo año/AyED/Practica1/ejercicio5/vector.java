package ejercicio5;

public class vector {
	private int[] vec;
	private int dimF;
	
	public vector(int dimF){
		this.dimF= dimF;
		vec = new int[dimF];
		for (int i = 0;i<dimF;i++) {
			vec[i] = i;
		}
	}
	
	public String devuelveReturn() {
		int max = -1; int min = 999; int total = 0; int i = 0;
		for (i = 0;i<this.getDimF();i++) {
			total += this.vec[i];
			if(this.vec[i] > max) {
				max = this.vec[i];
			}
			if(this.vec[i] < min) {
					min = this.vec[i];
			}	
				
		}
		float promedio = total/i;
		String aux = "Max:"+max
				+ " Min:"+min+" Promedio:"
				+ promedio;
		return aux;
	}
	public void devuelveParametro(ClaseValores val) {
		int max = -1; int min = 999; int total = 0; int i = 0;
		for (i = 0;i<this.getDimF();i++) {
			total += this.vec[i];
			if(this.vec[i] > max) {
				max = this.vec[i];
			}
			if(this.vec[i] < min) {
					min = this.vec[i];
			}	
				
		}
		float promedio = total/i;
		val.setMax(max);
		val.setMin(min);
		val.setProm(promedio);
	}
	
	public void noDevuelve() {
		int max = -1; int min = 999; int total = 0; int i = 0;
		for (i = 0;i<this.getDimF();i++) {
			total += this.vec[i];
			if(this.vec[i] > max) {
				max = this.vec[i];
			}
			if(this.vec[i] < min) {
					min = this.vec[i];
			}	
				
		}
		float promedio = total/i;
		System.out.println("Max:"+max+" Min:"+min+" Promedio:"+promedio);
	}
	
	public int getDimF() {
		return dimF;
	}
	public void setDimF(int dimF) {
		this.dimF = dimF;
	}
}
