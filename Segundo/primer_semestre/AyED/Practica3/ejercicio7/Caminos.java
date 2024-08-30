package Practica3.ejercicio7;
import java.util.*;

import ejercicio1_3.GeneralTree;

public class Caminos {
	GeneralTree<Integer> tree;
	
	public Caminos(GeneralTree<Integer> a) {
		this.tree = a;
	}

	public List<Integer> caminoAHojaMasLejana(){
		List<Integer> max_list = new LinkedList<Integer>();
		List<Integer> act_list = new LinkedList<Integer>();
		act_list.add(tree.getData());
		caminoAHojaMasLejana(tree,max_list,act_list);
		return max_list;
	}
	
	private void caminoAHojaMasLejana(GeneralTree<Integer> tree,List<Integer> max_list,List<Integer>act_list){
		if(tree.isLeaf()) {
			if(act_list.size() > max_list.size()) {
				max_list.clear();
				max_list.addAll(act_list);
			}
		}
		else {
			for(GeneralTree<Integer> child:tree.getChildren()) {
				act_list.add(child.getData());
				caminoAHojaMasLejana(child,max_list,act_list);
				act_list.remove(act_list.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(6, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(10));
        subChildren2.add(subA);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(17, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(9, subChildren3);
        
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(16));
        subChildren4.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(14, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(subB);
        subChildren5.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(15, subChildren5);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol);
        
        Caminos cam = new Caminos(a);
        
        System.out.println("Camino a hoja mas lejana: " + cam.caminoAHojaMasLejana());
 }
}
