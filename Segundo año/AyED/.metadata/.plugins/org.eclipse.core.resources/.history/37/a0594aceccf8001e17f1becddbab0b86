package ejercicio3;

import ejercicio2.BinaryTree;
import java.util.*;

public class mainn {

	public static void main(String[] args) {
		BinaryTree<Integer> a0 = new BinaryTree<Integer>(0);
		BinaryTree<Integer> a01 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a02 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> a0101 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> a0102 = new BinaryTree<Integer>(8);
		BinaryTree<Integer> a0201 = new BinaryTree<Integer>(10);
		BinaryTree<Integer> a0202 = new BinaryTree<Integer>(12);
		
		a0.addLeftChild(a01);
		a0.addRightChild(a02);
		a01.addLeftChild(a0101);
		a01.addRightChild(a0102);
		a02.addLeftChild(a0201);
		a02.addRightChild(a0202);
		
		List<Integer> lista = new LinkedList<Integer>();
		List<Integer> lista2 = new ArrayList<Integer>();
		ContadorArbol tree = new ContadorArbol(a0);
		
		System.out.println("Números pares inOrden:");
		lista = tree.numerosParesInOrden();
		System.out.println(lista);
		
		System.out.println("Números pares postOrden:");
		lista2 = tree.numerosParesPostOrden();
		System.out.println(lista2);
	}
}
