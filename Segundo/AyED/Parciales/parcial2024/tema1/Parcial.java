package tp5.parcial2024.tema1;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.*;

public class Parcial {
	
	public int resolver(Graph<Sitio> sitios, int tiempo) {
		int maxRecintos = 0;
		if(!sitios.isEmpty() && tiempo > 0) {
			Vertex<Sitio> entrada = buscar(sitios, "Entrada");
			if(entrada != null) {
				boolean[] marca = new boolean[sitios.getSize()];
				maxRecintos = resolver(sitios, tiempo, entrada, marca, maxRecintos, 0);
			}
		}
		return maxRecintos;
	}
	
	private Vertex<Sitio> buscar(Graph<Sitio> grafo, String buscado){
		Vertex<Sitio> vertice = null;
		Iterator<Vertex<Sitio>> it = grafo.getVertices().iterator();
		while(it.hasNext() && vertice == null) {
			Vertex<Sitio> v = it.next();
			if(v.getData().getNombre().equals(buscado)) {
				vertice = v;
			}
		}
		return vertice;
	}

	private int resolver(Graph<Sitio> grafo, int tiempo, Vertex<Sitio> entrada, boolean[] marca, int maxRecintos, int recintos) {
		marca[entrada.getPosition()] = true;
		tiempo = tiempo - entrada.getData().getTiempo();
		if(tiempo >= 0) {
			recintos++;
			if(tiempo > 0) {
				for(Edge<Sitio> e : grafo.getEdges(entrada)) {
					Vertex<Sitio> v = e.getTarget();
					int j = v.getPosition();
					if(!marca[j] && tiempo - e.getWeight() >= 0) {
						maxRecintos = resolver(grafo, tiempo - e.getWeight(), v, marca, maxRecintos, recintos);
					}
				}
			}
		}
		if(recintos > maxRecintos) {
			maxRecintos = recintos;
		}
		marca[entrada.getPosition()] = false;
		return maxRecintos;
	}
	
	public static void main(String args[]) {
        Graph<Sitio> grafo = new AdjListGraph<Sitio>();
        Vertex<Sitio> Entrada = grafo.createVertex(new Sitio("Entrada", 15));
        Vertex<Sitio> Cebras = grafo.createVertex(new Sitio("Cebras", 10));
        Vertex<Sitio> Tigres = grafo.createVertex(new Sitio("Tigres", 10));
        Vertex<Sitio> Flamencos = grafo.createVertex(new Sitio("Flamencos", 10));
        Vertex<Sitio> Murcielagos = grafo.createVertex(new Sitio("Murciélagos", 20));
        Vertex<Sitio> Wallabies = grafo.createVertex(new Sitio("Wallabies", 30));
        Vertex<Sitio> Tortugas = grafo.createVertex(new Sitio("Tortugas", 10));
        Vertex<Sitio> Pumas = grafo.createVertex(new Sitio("Pumas", 10));
        
        grafo.connect(Entrada, Cebras, 10);
        grafo.connect(Cebras, Entrada, 10);
        grafo.connect(Entrada, Tigres, 10);
        grafo.connect(Tigres, Entrada, 10);
        grafo.connect(Entrada, Murcielagos, 20);
        grafo.connect(Murcielagos, Entrada, 20);
        grafo.connect(Entrada, Flamencos, 25);
        grafo.connect(Flamencos, Entrada, 25);
        
        grafo.connect(Tigres, Cebras, 8);
        grafo.connect(Cebras, Tigres, 8);
        grafo.connect(Cebras, Tortugas, 10);
        grafo.connect(Tortugas, Cebras, 10);
        grafo.connect(Flamencos, Murcielagos, 25);
        grafo.connect(Murcielagos, Flamencos, 25);
        grafo.connect(Murcielagos, Wallabies, 10);
        grafo.connect(Wallabies, Murcielagos, 10);
        grafo.connect(Wallabies, Tortugas, 10);
        grafo.connect(Tortugas, Wallabies, 10);
        grafo.connect(Tortugas, Pumas, 15);
        grafo.connect(Pumas, Tortugas, 15);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, 100));
        System.out.println(p.resolver(grafo, 30));
    }
	
}
