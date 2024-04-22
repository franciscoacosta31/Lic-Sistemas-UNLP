package ejercicio1_3;

import java.util.LinkedList;
import java.util.List;

import utils.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
// EJERCICIO 2 
	public List<Integer> numerosImparesMayoresQuePreOrden(Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		numerosImparesMayoresQuePreOrden(n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePreOrden(Integer n, List<Integer> lista){
		int dato = (int) this.getData();
		if(dato%2!=0 && dato>n)
			lista.add(dato);
		List<GeneralTree<T>> children = this.getChildren();
		for(GeneralTree<T> child: children) {
			child.numerosImparesMayoresQuePreOrden(n,lista);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden(Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		numerosImparesMayoresQueInOrden(n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQueInOrden(Integer n, List<Integer> lista) {
		List<GeneralTree<T>> children = this.getChildren();
		if(this.hasChildren()) {
			children.get(0).numerosImparesMayoresQueInOrden(n,lista);
		}
		int dato = (int) this.getData();
		if(dato%2!=0 && dato>n) lista.add(dato);
		for(int i=1; i<children.size(); i++) {
			children.get(i).numerosImparesMayoresQueInOrden(n,lista);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden(Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		numerosImparesMayoresQuePostOrden(n,lista);
		return lista;
	}
	
	private void numerosImparesMayoresQuePostOrden(Integer n, List<Integer> lista) {
		List<GeneralTree<T>> children = this.getChildren();
		for(GeneralTree<T> child:children) {
			child.numerosImparesMayoresQuePostOrden(n,lista);
		}
		int dato = (int) this.getData();
		if(dato %2 != 0 && dato>n) lista.add(dato);
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(Integer n){
		List<Integer> lista = new LinkedList<Integer>();
		GeneralTree<T> aux;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		
		cola.enqueue(this);
		while(!cola.isEmpty()) {
			aux = cola.dequeue();
			int dato = (int) aux.getData();
			if(dato %2 != 0 && dato>n) lista.add(dato);
			List<GeneralTree<T>> children = aux.getChildren();
			for(GeneralTree<T> child:children) {
				cola.enqueue(child);
			}
		}
		return lista;
	}
	
	
	public int altura() {	 
		return alturaHelper();
	}
	
	private int alturaHelper() {
		if(this.isLeaf()) return 0;
		else {
			int alturaMax = -1;
			List<GeneralTree<T>> children = this.getChildren();
			for(GeneralTree<T> child:children) {
				alturaMax = Math.max(alturaMax, child.alturaHelper());
			}
			return alturaMax + 1;
		}
	}
	
	public int nivel(T dato){
		return 0;
	  }

	public int ancho(){
		
		return 0;
	}
}