package ejercicio1;

public class clase1 {

	public static void test1(int a, int b){
		for (int i = a; i<= b; i++) {
			System.out.println(i);
		}
	}
	
	public static void test2(int a, int b){
		while (a <= b) {
			System.out.println(a);
			a++;
		}
	}
	
	public static void test3(int a, int b) {
		if (a <= b) {
				System.out.println(a);
				clase1.test3(a+1, b);
			}
	}			
}