package practica3.ejercicio10;
import java.util.*;
import ejercicio1_3.GeneralTree;

public class ParcialArboles {
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List<Integer> act_list = new LinkedList<Integer>();
		Maximo max = new Maximo();
		int act_count = 0;
		int level = 0;
		if(arbol.getData() == 1)
			act_list.add(arbol.getData());
		return resolver(arbol,max,act_list,act_count,level);
	}
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol, Maximo max,List<Integer> act_list, int act_count, int level){
		if(arbol.isLeaf()) {
			if(act_count > max.getMax_count()) {
				max.setMax_count(act_count);
				max.getMax_list().clear();
				max.getMax_list().addAll(act_list);
			}
		}
		else {
			for(GeneralTree<Integer> child:arbol.getChildren()) {
				if(child.getData() == 1) {
					act_list.add(child.getData());
					resolver(child,max,act_list,act_count+level+1,level+1);
					act_list.remove(act_list.size()-1);
				}
				else
					resolver(child,max,act_list,act_count,level+1);
			}
		}
		return max.getMax_list();
	}
	
	public static void main(String[] args){
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        subChildren1.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subA = new GeneralTree<Integer>(1, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(subA);
        subChildren2.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(0, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> subB = new GeneralTree<Integer>(0, subChildren3);
        List<GeneralTree<Integer>> subChildren4 = new LinkedList<GeneralTree<Integer>>();
        subChildren4.add(subB);
        GeneralTree<Integer> subC = new GeneralTree<Integer>(0, subChildren4);
        List<GeneralTree<Integer>> subChildren5 = new LinkedList<GeneralTree<Integer>>();
        subChildren5.add(new GeneralTree<Integer>(1));
        subChildren5.add(subC);
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, subChildren5);
        
        List<GeneralTree<Integer>> subChildren6 = new LinkedList<GeneralTree<Integer>>();
        subChildren6.add(new GeneralTree<Integer>(0));
        subChildren6.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> subD = new GeneralTree<Integer>(0, subChildren6);
        List<GeneralTree<Integer>> subChildren7 = new LinkedList<GeneralTree<Integer>>();
        subChildren7.add(subD);
        GeneralTree<Integer> subE = new GeneralTree<Integer>(0, subChildren7);
        List<GeneralTree<Integer>> subChildren8 = new LinkedList<GeneralTree<Integer>>();
        subChildren8.add(subE);
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(1, subChildren8);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, arbol);
        
        System.out.println(resolver(a));
        
    }
	
}
