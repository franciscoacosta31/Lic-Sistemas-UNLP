package ejercicio2;

public class mainn {

	public static void main(String[] args) {
		BinaryTree<Integer> a0 = new BinaryTree<Integer>(0);
		BinaryTree<Integer> a01 = new BinaryTree<Integer>(2);
		BinaryTree<Integer> a02 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> a0101 = new BinaryTree<Integer>(6);
		BinaryTree<Integer> a0102 = new BinaryTree<Integer>(8);
		BinaryTree<Integer> a0201 = new BinaryTree<Integer>(10);
		
		a0.addLeftChild(a01);
		a0.addRightChild(a02);
		a01.addLeftChild(a0101);
		a01.addRightChild(a0102);
		a02.addLeftChild(a0201);
		
		a0.entreNiveles(0, 2);
	}
}
