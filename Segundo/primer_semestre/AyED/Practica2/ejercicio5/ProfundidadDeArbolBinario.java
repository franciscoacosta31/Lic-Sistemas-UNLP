package ejercicio5;
import ejercicio2.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> tree;
	
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arb) {
		this.tree = arb;
	}
	
	public int sumaElementosProfundidad(int level) {
		return sumaElementos(this.tree,level,0);
	}
	
	private int sumaElementos(BinaryTree<Integer> ab, int level,int nivelActual){
		if (level == nivelActual)
			return ab.getData();
		else {
			int total = 0;
			if (ab.hasLeftChild()) total += sumaElementos(ab.getLeftChild(), level, nivelActual+1);
			if (ab.hasRightChild()) total += sumaElementos(ab.getRightChild(), level, nivelActual+1);
			return total;
		}
	}
	
	public static void main(String []args) {
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
        
        ProfundidadDeArbolBinario tree = new ProfundidadDeArbolBinario(arb);
        
        System.out.println(tree.sumaElementosProfundidad(3));
        
	}
}