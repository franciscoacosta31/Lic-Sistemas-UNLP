package ejercicio4;
import ejercicio2.BinaryTree;

public class RedBinariaLlena {
	
	private BinaryTree<Integer> tree;
	
	public RedBinariaLlena(BinaryTree<Integer> ar) {
		this.tree = ar;
	}
	
	public int retardoReenvio() {
		return this.retardoRecursion(tree);
	}
	
	private int retardoRecursion(BinaryTree<Integer> arb) {
		int hi = 0;
		int hd = 0;
		
		if(arb.isLeaf())
			return arb.getData();
		
		if(arb.hasLeftChild())
			hi = retardoRecursion(arb.getLeftChild());
		
		if(arb.hasRightChild())
			hd = retardoRecursion(arb.getRightChild());
		
		if(hi > hd)
			return hi+arb.getData();
		else
			return hd+arb.getData();
	}
	
	public static void main(String[] args) {
        BinaryTree<Integer> arb = new BinaryTree<Integer>(10);
        arb.addLeftChild(new BinaryTree<Integer>(2));
        arb.addRightChild(new BinaryTree<Integer>(3));
        arb.getLeftChild().addLeftChild(new BinaryTree<Integer>(5));
        arb.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        arb.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
        arb.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        arb.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
        arb.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
        arb.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(12));
        arb.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(2));
        
        RedBinariaLlena tree = new RedBinariaLlena(arb);
        
        System.out.println(tree.retardoReenvio());
	}
	
}
