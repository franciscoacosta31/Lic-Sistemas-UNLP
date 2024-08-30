package ejercicio7;

import java.util.*;

public class Sucesion {
	public List<Integer> lista = new ArrayList<Integer>();
	
	public List<Integer> ObtenerSucesion(int n){
		
		if (n % 2 == 0) {
			n = n /2;
			this.lista.add(n);
			ObtenerSucesion(n);
		}
		else if ((n % 2 != 0)&&(n != 1)){
			n = n*3 + 1;
			this.lista.add(n);
			ObtenerSucesion(n);
		}
		
		return this.lista;
	}
	
	public static void main(String[] args) {
		List<Integer> lista2 = new ArrayList<Integer>();
		Sucesion sucesion = new Sucesion();
		lista2 = sucesion.ObtenerSucesion(6);
		for(int e:lista2) {
			System.out.println(e);
		}
	}
}