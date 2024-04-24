package ejercicio7;
import ejercicio2.BinaryTree;

public class ParcialArboles {
	BinaryTree<Integer> tree;
	
	public ParcialArboles(BinaryTree<Integer> arb) {
		this.tree = arb;
	}
	
	public BinaryTree<Integer> getNum(int num) {
		return this.getAr(this.tree,num);
	}
	
	private BinaryTree<Integer> getAr(BinaryTree<Integer> arb, int num){
		if(arb.getData() == num) {
			return arb;
		}
		else { 
			BinaryTree<Integer> nodo = new BinaryTree<Integer>();
			if(arb.hasLeftChild())
				nodo = this.getAr(arb.getLeftChild(), num);
			
			if(arb.hasRightChild() && nodo == null)
				nodo = this.getAr(arb.getRightChild(), num);
			
			return nodo;
		}
	}
	
	public int countTrees(BinaryTree<Integer> arb) {
		int cant = 0;
		
		if(arb.hasLeftChild()) {
			cant+=countTrees(arb.getLeftChild());
		}
		if(arb.hasRightChild()) {
			cant+=countTrees(arb.getRightChild());
		}
		
		if((arb.hasLeftChild() && !arb.hasRightChild()) || (!arb.hasLeftChild() && arb.hasRightChild())){
			cant++;
		}
		
		return cant;
	}
	
	
	public boolean isLeftTree(int num) {
		BinaryTree<Integer> tree = this.getNum(num);		
		int cantL=-1; int cantR=-1;
		
		if(tree.hasLeftChild()) {
			cantL = this.countTrees(tree.getLeftChild());
		}
		
		if(tree.hasRightChild()) {
			cantR = this.countTrees(tree.getRightChild());
		}
		
		return cantL>cantR;
	}
	
	
	public static void main(String[] args) {
		BinaryTree<Integer> arb = new BinaryTree<Integer>(2);
        arb.addLeftChild(new BinaryTree<Integer>(7));
        arb.addRightChild(new BinaryTree<Integer>(-5));
        arb.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        arb.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        arb.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        arb.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        arb.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        arb.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        arb.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        arb.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
                
        
        ParcialArboles ar = new ParcialArboles(arb);
        System.out.println(ar.isLeftTree(7));
	}
	
}
