package ejercicio5;

public class ClaseMain {

	public static void main(String[] args) {
		// Inciso A
		vector vec = new vector(5);
		System.out.println(vec.devuelveReturn());
		
		// Inciso B
		ClaseValores valores = new ClaseValores();
		vec.devuelveParametro(valores);
		System.out.println(valores);
		
		// Inciso C
		vec.noDevuelve();
	}
}
