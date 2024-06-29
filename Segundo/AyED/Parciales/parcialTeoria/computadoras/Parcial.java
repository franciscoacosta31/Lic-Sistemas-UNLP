package parciales.parcialTeoria.computadoras;

import java.util.*;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.*;

public class Parcial {
	
	public int infectar(Graph<String> grafo, Vertex<String> inicial) {
		int tiempo = 0;
		if(!grafo.isEmpty() && inicial != null) {
			boolean[] marca = new boolean[grafo.getSize()];
			marca[inicial.getPosition()] = true;
			Queue<Vertex<String>> cola = new Queue<Vertex<String>>();
			cola.enqueue(inicial);
			cola.enqueue(null);
			while(!cola.isEmpty()) {
				Vertex<String> v = cola.dequeue();
				if(v != null) {
					List<Edge<String>> ady = grafo.getEdges(v);
					for(Edge<String> e : ady) {
						Vertex<String> ve = e.getTarget();
						if(!marca[ve.getPosition()]) {
							marca[ve.getPosition()] = true;
							cola.enqueue(ve);
						}
					}
				}
				else if(!cola.isEmpty()){
					tiempo++;
					cola.enqueue(null);
				}
			}
		}
		return tiempo;
	}
}
