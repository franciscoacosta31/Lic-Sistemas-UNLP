package ejercicio3; import ejercicio2.BinaryTree; import java.util.*;

public class ContadorArbol {
	
	private BinaryTree<Integer> arb;
	
	public ContadorArbol(BinaryTree<Integer> tree){
		this.arb = tree;
	}
	
	public List<Integer> numerosParesInOrden() {
		List<Integer> lista = new LinkedList<Integer>();
		this.numParesInOrden(this.arb,lista);
		return lista;
	}
	
	private void numParesInOrden(BinaryTree<Integer> tree, List<Integer> lista){
		
		if(!tree.isEmpty()) {
			if(tree.hasLeftChild())
				numParesInOrden(tree.getLeftChild(),lista);
			
			if(tree.getData() % 2 == 0) 
				lista.add(tree.getData());
			
			if(tree.hasRightChild())
				numParesInOrden(tree.getRightChild(),lista);
		}
	}
	
	public List<Integer> numerosParesPostOrden() {
		List<Integer> lista = new LinkedList<Integer>();
		this.numParesPostOrden(this.arb,lista);
		return lista;
	}
	
	private void numParesPostOrden(BinaryTree<Integer> tree, List<Integer> lista){
		
		if(!tree.isEmpty()) {
			if(tree.hasLeftChild())
				numParesPostOrden(tree.getLeftChild(),lista);
			
			if(tree.hasRightChild())
				numParesPostOrden(tree.getRightChild(),lista);
			
			if(tree.getData() % 2 == 0) 
				lista.add(tree.getData());
		}
	}
}
