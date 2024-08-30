package tp5.ejercicio5;
import java.util.*;
import tp5.ejercicio1.*;
import tp1.ejercicio8.Queue;


public class SueldoJubilados {
	
	public List<Persona> listaJubilados(Graph<Persona> grafo, Vertex<Persona> empleado, int distancia) {
		List<Persona> lis = new LinkedList<Persona>();
		if(!grafo.isEmpty() && distancia > 0) {
			if(empleado != null) {
				boolean[] marca = new boolean[grafo.getSize()];
				marca[empleado.getPosition()] = true;
				int cantidad = 0;
				Queue<Vertex<Persona>> cola = new Queue<Vertex<Persona>>();
				cola.enqueue(empleado);
				cola.enqueue(null);
				while(!cola.isEmpty() && distancia >= 0 && lis.size() < 40) {
					Vertex<Persona> v = cola.dequeue();
					if(v != null) {
						if(v != empleado && !v.getData().getCobró() && cantidad < 40 && v.getData().isJubilado()) {
							lis.add(v.getData());
						}
						List<Edge<Persona>> ady = grafo.getEdges(v);
						Iterator<Edge<Persona>> it = ady.iterator();
						while(it.hasNext())
						for(Edge<Persona> e : ady) {
							int j = e.getTarget().getPosition();
							if(!marca[j]) {
								marca[j] = true;
								cola.enqueue(e.getTarget());
							}
						}
					} else if(!cola.isEmpty()) {
						distancia--;
						cola.enqueue(null);
					}
				}
			}
		}
		return lis;
	}
}
