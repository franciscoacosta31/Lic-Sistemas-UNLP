package Practica3.ejercicio8;
import java.util.*;
import ejercicio1_3.GeneralTree;

public class Navidad {
	GeneralTree<Integer> tree = new GeneralTree<Integer>();
	
	public Navidad(GeneralTree<Integer> a1) {
		this.tree = a1;
	}

	public String esAbetoNavidenio() {
		boolean ok = esAbetoNavidenio(tree);
		if(ok)
			return "Cumple";
		else
			return "No cumple";
	}
	
	private boolean esAbetoNavidenio(GeneralTree<Integer> tree) {
		int leaf_count = 0; boolean child_ok = true;
		if(tree.hasChildren()) {
			for(GeneralTree<Integer> child:tree.getChildren()) {
				if(child.isLeaf())
					leaf_count++;
				else
					child_ok = (child_ok && esAbetoNavidenio(child));
			}
		}
		return leaf_count >= 3 && child_ok;
	}
	
	public static void main(String[] args) {
        List<GeneralTree<Integer>> subArb1 = new LinkedList<GeneralTree<Integer>>();
        subArb1.add(new GeneralTree<Integer>(2));
        subArb1.add(new GeneralTree<Integer>(3));
        subArb1.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1, subArb1);
        
        List<GeneralTree<Integer>> subArb2A = new LinkedList<GeneralTree<Integer>>();
        subArb2A.add(new GeneralTree<Integer>(5));
        subArb2A.add(new GeneralTree<Integer>(6));
        subArb2A.add(new GeneralTree<Integer>(7));
        GeneralTree<Integer> subA2 = new GeneralTree<Integer>(2, subArb2A);
        List<GeneralTree<Integer>> subArb2B = new LinkedList<GeneralTree<Integer>>();
        subArb2B.add(subA2);
        subArb2B.add(new GeneralTree<Integer>(3));
        subArb2B.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subArb2B);
        
        List<GeneralTree<Integer>> subArb3A = new LinkedList<GeneralTree<Integer>>();
        subArb3A.add(new GeneralTree<Integer>(6));
        subArb3A.add(new GeneralTree<Integer>(7));
        subArb3A.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> subA3 = new GeneralTree<Integer>(3, subArb3A);
        List<GeneralTree<Integer>> subArb3B = new LinkedList<GeneralTree<Integer>>();
        subArb3B.add(new GeneralTree<Integer>(2));
        subArb3B.add(subA3);
        subArb3B.add(new GeneralTree<Integer>(4));
        subArb3B.add(new GeneralTree<Integer>(5));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subArb3B);
        
        Navidad nav1 = new Navidad(a1);
        Navidad nav2 = new Navidad(a2);
        Navidad nav3 = new Navidad(a3);
        
        System.out.println("Es abeto navidenio A1? " + nav1.esAbetoNavidenio());
        System.out.println("Es abeto navidenio A2? " + nav2.esAbetoNavidenio());
        System.out.println("Es abeto navidenio A3? " + nav3.esAbetoNavidenio());
    }
}