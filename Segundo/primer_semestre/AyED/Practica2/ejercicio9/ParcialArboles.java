package ejercicio9;
import ejercicio2.BinaryTree;

public class ParcialArboles {
	
	public BinaryTree<SumDif> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<SumDif> arbolsd = new BinaryTree<SumDif>();
		this.sumAndDif(arbol,arbolsd,0,0);
		return arbolsd;
	}
	
	private void sumAndDif(BinaryTree<Integer> arbol, BinaryTree<SumDif> arbolsd, int sum, int dif){
		SumDif sd = new SumDif(arbol.getData()+sum,arbol.getData()-dif);
		arbolsd.setData(sd);
		
		if(arbol.hasLeftChild()) {
			arbolsd.addLeftChild(new BinaryTree<SumDif>());
			sumAndDif(arbol.getLeftChild(),arbolsd.getLeftChild(),sd.getSum(),arbol.getData());
		}
		if(arbol.hasRightChild()) {
			arbolsd.addRightChild(new BinaryTree<SumDif>());
			sumAndDif(arbol.getRightChild(),arbolsd.getRightChild(),sd.getSum(),arbol.getData());
		}
	}	
}