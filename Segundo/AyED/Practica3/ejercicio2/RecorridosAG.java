package ejercicio2;
import utils.Queue; import java.util.*;

import ejercicio1_3.GeneralTree;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if(a.isEmpty()) return lista;
		numerosImparesMayoresQuePreOrdenHelper(a,n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePreOrdenHelper(GeneralTree<Integer> a, Integer n, List<Integer> lista){
		int dato = a.getData();
		if(dato%2!=0 && dato>n)
			lista.add(dato);
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child: children) {
			numerosImparesMayoresQuePreOrdenHelper(child,n,lista);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if(a.isEmpty()) return lista;
		numerosImparesMayoresQueInOrdenHelper(a,n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQueInOrdenHelper(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
		List<GeneralTree<Integer>> children = a.getChildren();
		if(a.hasChildren()) {
			numerosImparesMayoresQueInOrdenHelper(children.get(0),n,lista);
		}
		int dato = a.getData();
		if(dato%2!=0 && dato>n) lista.add(dato);
		for(int i=1; i<children.size(); i++) {
			numerosImparesMayoresQueInOrdenHelper(children.get(i),n,lista);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		if(a.isEmpty()) return lista;
		numerosImparesMayoresQuePostOrdenHelper(a,n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePostOrdenHelper(GeneralTree<Integer> a, Integer n, List<Integer> lista) {
		List<GeneralTree<Integer>> children = a.getChildren();
		for(GeneralTree<Integer> child:children) {
			numerosImparesMayoresQuePostOrdenHelper(child,n,lista);
		}
		int dato = a.getData();
		if(dato %2 != 0 && dato>n) lista.add(dato);
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<Integer> a, Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		GeneralTree<Integer> aux;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		
		cola.enqueue(a);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			int dato = aux.getData();
			if(dato %2 != 0 && dato>n) lista.add(dato);
			List<GeneralTree<Integer>> children = aux.getChildren();
			for(GeneralTree<Integer> child:children) {
				cola.enqueue(child);
			}
		}
		return lista;
	}
	
	
	public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
        children.add(a1);children.add(a2);children.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(0, children);
        
        RecorridosAG r = new RecorridosAG();
        
        System.out.println("PREORDEN:" + r.numerosImparesMayoresQuePreOrden(a, 0));
        System.out.println("INORDEN:" + r.numerosImparesMayoresQueInOrden(a, 0));
        System.out.println("POSTORDEN:" + r.numerosImparesMayoresQuePostOrden(a, 0));
        System.out.println("POR NIVELES:" + r.numerosImparesMayoresQuePorNiveles(a, 0));
	}
}
