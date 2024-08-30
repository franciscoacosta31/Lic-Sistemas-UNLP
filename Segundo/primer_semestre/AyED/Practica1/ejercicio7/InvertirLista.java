package ejercicio7;

import java.util.*;

public class InvertirLista {
	
	public static List<Integer> Invertir(List<Integer> lista, List<Integer> lista2, int dimf){
		
		if (dimf>=0) {
			lista2.add(lista.get(dimf));
			Invertir(lista,lista2,dimf -1);
		}
		return lista2;
	}
	
	public static void main(String[] args) {
		// Lista cargada
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(1);lista.add(2);lista.add(3);lista.add(4);
		// Lista vacia
		List<Integer> listaInvertida = new ArrayList<Integer>();
		Invertir(lista,listaInvertida,lista.size()-1);
		
		System.out.println("Lista Ordenada");
		for(int x:lista) {
			System.out.println(x);
		}
		
        System.out.println("Lista invertida");
        for (int x : listaInvertida) {
            System.out.println(x);
        }
	}
}	
