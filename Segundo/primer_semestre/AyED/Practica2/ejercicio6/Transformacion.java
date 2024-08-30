package ejercicio6;
import ejercicio2.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> tree;
	
	public Transformacion(BinaryTree<Integer> arb) {
		this.tree = arb;
	}
	
	public BinaryTree<Integer> suma(){
		sum(this.tree);
		return this.tree;
	}
	
	private int sum(BinaryTree<Integer> arb){
		int total = 0;
		if (arb.isLeaf()) {
			total = arb.getData();
			arb.setData(0);
			return total;
		}
		else {
			if (arb.hasLeftChild()) total+= sum(arb.getLeftChild());
			if (arb.hasRightChild()) total+= sum(arb.getRightChild());
			
			int valor = arb.getData();
			arb.setData(total);
			return total + valor;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> arb = new BinaryTree<Integer>(1);
        arb.addLeftChild(new BinaryTree<Integer>(2));
        arb.addRightChild(new BinaryTree<Integer>(3));
        arb.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        arb.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        arb.getRightChild().addRightChild(new BinaryTree<Integer>(6));
        arb.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
        arb.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
        
        Transformacion arbol = new Transformacion(arb);
        BinaryTree<Integer>treee = arbol.suma();
        treee.entreNiveles(0, 3);
	}
}
