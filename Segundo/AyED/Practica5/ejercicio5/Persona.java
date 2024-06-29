package tp5.ejercicio5;

public class Persona {
	public boolean jubilado;
	public boolean cobró;
	
	public Persona(boolean esJubilado, boolean cobróJubilación){
		this.jubilado = esJubilado;
		this.cobró = cobróJubilación;
	}

	public boolean isJubilado() {
		return jubilado;
	}

	public void setJubilado(boolean jubilado) {
		this.jubilado = jubilado;
	}

	public boolean getCobró() {
		return cobró;
	}

	public void setCobró(boolean cobró) {
		this.cobró = cobró;
	}
	
	
}
