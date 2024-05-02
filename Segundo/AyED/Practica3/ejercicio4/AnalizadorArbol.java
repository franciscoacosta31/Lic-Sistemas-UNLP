package ejercicio4;
import java.util.*;import ejercicio1_3.GeneralTree;import utils.Queue;

public class AnalizadorArbol {
	
	
	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		if (arbol.isEmpty()) return -1.0;
		return devolverMaximoPromedioHelper(arbol);
	}
	
	private double devolverMaximoPromedioHelper(GeneralTree<AreaEmpresa> arbol) {
		GeneralTree<AreaEmpresa> ab = null;
		Queue<GeneralTree<AreaEmpresa>> queue = new Queue<GeneralTree<AreaEmpresa>>();
		int cant=0; int total=0; float average; float max_average=0;
		queue.enqueue(arbol);
		queue.enqueue(null);
		while (!queue.isEmpty()) {
			ab = queue.dequeue();
			if (ab != null) {
				if(ab.hasChildren());
					List<GeneralTree<AreaEmpresa>> children = ab.getChildren();
					for(GeneralTree<AreaEmpresa> child:children) {
						queue.enqueue(child);
						cant++; total+=child.getData().getTime(); 
					}
			} 
			else if (!queue.isEmpty()) {
				//Calculo el promedio y actualizo el maximo si es el caso
				average = total/cant;
				if(average > max_average)
					max_average = average;
				//Reinicio el valor de las variables para el nuevo nivel
				cant=0; total=0;
				//Establezco fin de nivel
				queue.enqueue(null);
			}
		}
		return max_average;
    }
	
	public static void main(String[] args) {
        List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4)));
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7)));
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5)));
        GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13), children1);
        
        List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18)));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25), children2);
        
        List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19)));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10), children3);
        
        List<GeneralTree<AreaEmpresa>> children4 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",14), children4);
        
        AnalizadorArbol arb = new AnalizadorArbol();
        System.out.println("El mayor promedio es: "+arb.devolverMaximoPromedio(a));
    }
}
