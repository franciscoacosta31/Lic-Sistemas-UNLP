package ejercicio7;

public abstract class Capicua {
	public static boolean EsCapicua(int n) {
		int numero = n;
		int invertido = 0;
		int digito;
		
		while (n!= 0) {
			digito = n % 10;
			invertido = invertido * 10 + digito;
			n = n / 10;
		}

		return invertido == numero;
	}
}
