package ejercicio8;
import ejercicio2.BinaryTree;

public class ParcialArboles {
		
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean left = true; boolean right = true;
		
		if(arbol1.hasLeftChild()) {
			if(arbol2.hasLeftChild()) {
				left = esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild());
			}
			else return false;
		}
		if(arbol1.hasRightChild()) {
			if(arbol2.hasRightChild()) {
				right = esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());
			}
			else return false;	
		}
		if(arbol1.getData() == arbol2.getData() && left && right) 
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ar1 = new BinaryTree<Integer>(65);
		ar1.addLeftChild(new BinaryTree<Integer>(37));
		ar1.addRightChild(new BinaryTree<Integer>(81));
		ar1.getLeftChild().addRightChild(new BinaryTree<Integer>(47));
		ar1.getRightChild().addRightChild(new BinaryTree<Integer>(93));
		
		BinaryTree<Integer> ar2 = new BinaryTree<Integer>(65);
		ar2.addLeftChild(new BinaryTree<Integer>(37));
		ar2.addRightChild(new BinaryTree<Integer>(81));
		ar2.getLeftChild().addLeftChild(new BinaryTree<Integer>(22));
		ar2.getLeftChild().addRightChild(new BinaryTree<Integer>(47));
		ar2.getRightChild().addLeftChild(new BinaryTree<Integer>(76));
		ar2.getRightChild().addRightChild(new BinaryTree<Integer>(93));
		ar2.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(85));
		ar2.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(94));
		ar2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(11));
		ar2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(29));
		
		ParcialArboles arb = new ParcialArboles();
		
		System.out.println(arb.esPrefijo(ar1,ar2));
	}
	
}
