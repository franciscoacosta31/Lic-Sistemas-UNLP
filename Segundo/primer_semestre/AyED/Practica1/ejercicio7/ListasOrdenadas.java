package ejercicio7;
import java.util.*;

public class ListasOrdenadas {

	public static List<Integer> combinarOrdenado(List<Integer> lista1,List<Integer> lista2){
		List<Integer> lista3 = new ArrayList<Integer>();
		int i = 0; int j = 0;
		
		while(i < lista1.size() && j < lista2.size()) {
			if (lista1.get(i) < lista2.get(j)) {
				lista3.add(lista1.get(i)); i++;
			}
			else {
				lista3.add(lista2.get(j)); j++;
			}
		}
		while (i < lista1.size()) {
            lista3.add(lista1.get(i));
            i++;
        }
        
        while (j < lista2.size()) {
            lista3.add(lista2.get(j));
            j++;
        }
        return lista3;
	}
	
	public static void main(String[] args) {
		List<Integer> lista1 = new ArrayList<Integer>();
		lista1.add(1);lista1.add(4);lista1.add(5);
		List<Integer> lista2 = new ArrayList<Integer>();
		lista2.add(2);lista2.add(3);lista2.add(6);
		
		List<Integer> lista3 = ListasOrdenadas.combinarOrdenado(lista1,lista2);
		System.out.println(lista3);
	}
}
