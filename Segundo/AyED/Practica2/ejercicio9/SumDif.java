package ejercicio9;

public class SumDif {
	private int sum;
	private int dif;
	
	public SumDif() {
		this.sum = 0;
		this.dif = 0;
	}
	
	public SumDif(int num, int num2) {
		this.sum = num;
		this.dif = num2;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getDif() {
		return dif;
	}

	public void setDif(int dif) {
		this.dif = dif;
	}

}

