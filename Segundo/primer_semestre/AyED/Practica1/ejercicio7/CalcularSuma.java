package ejercicio7;

import java.util.*;

public class CalcularSuma {
	
	public static int sumador(List<Integer> lista, int tam){
		if (tam<0) {
			return 0;
		}
		else{
			return lista.get(tam) + sumador(lista,tam-1);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> lista = new LinkedList<Integer>();
		lista.add(5);lista.add(10);lista.add(15);
		System.out.println(sumador(lista,lista.size()-1));
	}
}