package ejercicio2;
import java.util.Scanner;
public class ClaseMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		vector vec = new vector();
		int n = s.nextInt();
		vec.crearVector(n);
		System.out.println(vec.toString());
	}
}