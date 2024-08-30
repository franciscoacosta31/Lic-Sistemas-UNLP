package tp5.ejercicio3;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.*;

public class Mapa {
	private Graph<String> mapaCiudades;
	
	public Mapa (Graph<String> mapa) {
		this.mapaCiudades = mapa;
	}
	
	public List<String> devolverCamino(String ciudad1, String ciudad2) {
		boolean[] marca = new boolean[this.mapaCiudades.getSize()];
		List<String> camino = new LinkedList<String>();
		Vertex<String> origen = this.mapaCiudades.search(ciudad1);
		Vertex<String> destino = this.mapaCiudades.search(ciudad2);
		if (origen != null && destino != null) {
			devolverCamino(origen, destino, camino, marca);
		}
		return camino;
	}
	
	private boolean devolverCamino(Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean[] marca) {
		boolean ok = false;
		// Marco el vértice como visitado
		marca[origen.getPosition()] = true;
		// Agrego el vértice al camino
		camino.add(origen.getData());
		// Si origen = destino llegué y termino
		if (origen == destino) {
			return true;
		}
		else {
			// Sino recorro los adyacentes
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = ady.iterator();
			while (it.hasNext() && !ok) {
				Vertex<String> v = it.next().getTarget();
				int j = v.getPosition();
				if (!marca[j]) {
					// Llamo con los adyacentes
					ok = devolverCamino(v, destino, camino, marca);
				}
			}
		}
		if (!ok) {
			//Elimino el vértice actual del camino porque no llegué a destino
			camino.remove(camino.size()-1);
		}
		return ok;
	}

	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new LinkedList<String>();
        if (!this.mapaCiudades.isEmpty()) {
            Vertex<String> origen = this.mapaCiudades.search(ciudad1);
            Vertex<String> destino = this.mapaCiudades.search(ciudad2);
            if (origen != null && destino != null) {
                boolean [] marca = new boolean[this.mapaCiudades.getSize()];
                marcarCiudades(ciudades, marca);
                devolverCamino(origen, destino, camino, marca);
            }
        }
        return camino;
	}
	
	// Marca las ciudades exceptuadas como visitadas
	private void marcarCiudades(List<String> ciudades, boolean[] marca) {
		for (String ciudad : ciudades) {
			Vertex<String> v = this.mapaCiudades.search(ciudad);
			if (v != null) {
				marca[v.getPosition()] = true;
			}
		}
	}
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
		if(!this.mapaCiudades.isEmpty()) {
			boolean[] marca = new boolean[this.mapaCiudades.getSize()];
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			if(origen != null && destino != null) {
				caminoMasCorto(origen, destino, camino, new LinkedList<String>(), marca, 0, Integer.MAX_VALUE);
			}
		}
		return camino;
	}
	
	private int caminoMasCorto(Vertex<String> origen, Vertex<String> destino, List<String> caminoMinimo, 
			List<String> caminoActual, boolean[] marca, int total, int min) {
		marca[origen.getPosition()] = true;
		caminoActual.add(origen.getData());
		if (origen == destino && total < min) {
			// Si llegué a destino, verifico si el camino es menor al minimo, si es actualizo.
			caminoMinimo.removeAll(caminoMinimo);
			caminoMinimo.addAll(caminoActual);
			min = total;
		}
		else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = ady.iterator();
			// Itero con todos los adyacentes
			while (it.hasNext() && total < min) {
				Edge<String> e = it.next();
				// j = pos del ady
				int j = e.getTarget().getPosition();
				// x = peso acumulado
				int x = total + e.getWeight();
				if (!marca[j] && x < min) {
					min = caminoMasCorto(e.getTarget(), destino, caminoMinimo, caminoActual, marca, x, min);
				}
			}
		}
		// Desmarco el vértice visitado y lo elimino de la lista
		// Elimino de la lista porque la lista que debe guardar todos los datos es caminoMinimo
		marca[origen.getPosition()] = false;
		caminoActual.remove(caminoActual.size()-1);
		return min;
	}
	
	public List<String> caminoSinCargarCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		List<String> camino = new LinkedList<String>();
		if (!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			if (origen != null && destino != null) {
				caminoSinCargarCombustible(origen, destino, camino, new boolean[this.mapaCiudades.getSize()], tanqueAuto);
			}
		}
		return camino;
	}
	
	private boolean caminoSinCargarCombustible(Vertex<String> origen, Vertex<String> destino, List<String> camino, 
			boolean[] marca, int tanqueAuto) {
		boolean ok = false;
		marca[origen.getPosition()] = true;
		camino.add(origen.getData());
		if (origen == destino) {
			return true;
		}
		else {
			List<Edge<String>> ady = mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = ady.iterator();
			while (it.hasNext() && !ok) {
				Edge<String> e = it.next();
				int j = e.getTarget().getPosition();
				if (!marca[j] && tanqueAuto - e.getWeight() > 0){
					ok = caminoSinCargarCombustible(e.getTarget(), destino, camino, marca, tanqueAuto - e.getWeight()); 
				}
			}
		}
		if (!ok) {
			// Elimino de la lista solo si no llegué a destino
			camino.remove(camino.size()-1);
		}
		marca[origen.getPosition()] = false;
		return ok;
	}
	
	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> caminoMin = new LinkedList<String>();
		if (!this.mapaCiudades.isEmpty()) {
			Vertex<String> origen = this.mapaCiudades.search(ciudad1);
			Vertex<String> destino = this.mapaCiudades.search(ciudad2);
			if (origen != null && destino != null) {
				caminoConMenorCargaDeCombustible(origen, destino, caminoMin, new LinkedList<String>(), new boolean[this.mapaCiudades.getSize()], tanqueAuto, tanqueAuto, 0, Integer.MAX_VALUE);
			}
		}
		return caminoMin;
	}
	
	private int caminoConMenorCargaDeCombustible(Vertex<String> origen, Vertex<String> destino, List<String> caminoMin, 
			List<String> caminoAct, boolean[] marca, int tanqueAct, int tanque, int recargas, int recargasMin) {
		marca[origen.getPosition()] = true;
		caminoAct.add(origen.getData());
		if (origen == destino && recargas < recargasMin) {
			caminoMin.removeAll(caminoMin);
			caminoMin.addAll(caminoAct);
			recargasMin = recargas;
		}
		else {
			List<Edge<String>> ady = this.mapaCiudades.getEdges(origen);
			Iterator<Edge<String>> it = ady.iterator();
			while (it.hasNext() && recargas < recargasMin) {
				Edge<String> e = it.next();
				int j = e.getTarget().getPosition();
				int distancia = e.getWeight();
				if (!marca[j]) {
					if (tanqueAct >= distancia) {
						recargasMin = caminoConMenorCargaDeCombustible(e.getTarget(), destino, caminoMin, caminoAct, marca, tanqueAct - distancia, tanque, recargas, recargasMin);
					}
					// Entra si el tanque no alcanza y necesita una recarga
					else if (tanque >= distancia) {
						recargasMin = caminoConMenorCargaDeCombustible(e.getTarget(), destino, caminoMin, caminoAct, marca, tanque - distancia, tanque, recargas+1, recargasMin);
					}
				}
			}
		}
		marca[origen.getPosition()] = false;
		caminoAct.remove(caminoAct.size()-1);
		return recargasMin;
	}
	
	
    public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); 
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada");
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso");
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); 
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); 
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron");
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente");
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(mapaCiudades);
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.print(mapa.devolverCamino("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
        List<String> restringidos = new LinkedList<String>();
        restringidos.add("Berisso");
        System.out.print(mapa.devolverCaminoExceptuando("La Plata", "San Vicente", restringidos));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): ");
        System.out.print(mapa.caminoMasCorto("La Plata", "San Vicente"));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO SIN CARGAR COMBUSTIBLE: ");
        System.out.print(mapa.caminoSinCargarCombustible("La Plata", "San Vicente", 30));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO CON MENOR CARGAS DE COMBUSTIBLE: ");
        System.out.print(mapa.caminoConMenorCargaDeCombustible("La Plata", "San Vicente", 10));
        
        System.out.println("");
    }
}
