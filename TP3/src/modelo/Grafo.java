package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import interfaz.IGrafo;
import interfaz.INodo;
import interfaz.IPersona;

public class Grafo<T extends IPersona> implements IGrafo<T> {
	
	private Map<T, INodo<T>> nodos = new HashMap<>();
	private boolean dirigido = false;
	
	public Grafo() {
		this.dirigido = false;
	}
	
	public Grafo(boolean dirigido) {
		this.dirigido = dirigido;
	}
	
	public Map<T, INodo<T>> getNodos() {
		return nodos;
	}
	
	public void setDirigido(boolean dirigido) {
		this.dirigido = dirigido;
	}
	
	public boolean esDirigido() {
		return dirigido;
	}
	
	//Metodos

	public void agregarNodo(T valor) {
		nodos.putIfAbsent(valor, new Nodo(valor));
	}
	
	public void agregarArista(T origen, T destino, int peso) {
		INodo<T> nodoOrigen = nodos.get(origen);
		INodo<T> nodoDestino = nodos.get(destino);
		if (nodoOrigen != null && nodoDestino != null) {
			nodoOrigen.agregarVecino(nodoDestino, peso);
			// Solo agregar la arista inversa si el grafo NO es dirigido
            if (!dirigido) {
            	nodoDestino.agregarVecino(nodoOrigen, peso);
            }
		}
	}
	
	public void mostrarListaAdyacencia() {
		System.out.println("Lista de Adyacencia (" + (dirigido ? "Dirigido" : "No Dirigido") + "):");
		for (INodo<T> nodo : nodos.values()) {
			System.out.print(nodo.getDato() + ": ");
            List<INodo<T>> vecinos = nodo.getVecinos();
            List<Integer> pesos = nodo.getPesos();
            
            for (int i = 0; i < vecinos.size(); i++) {
                System.out.print("(" + vecinos.get(i).getDato() + ", peso=" + pesos.get(i) + ") ");
            }
            System.out.println();
		}
	}
	
	public void mostrarMatrizAdyacencia() {
	     System.out.println("Matriz de Adyacencia (" + (dirigido ? "Dirigido" : "No Dirigido") + "):");
	     List<T> claves = new ArrayList<>(nodos.keySet());
	     Collections.sort(claves); 
	     System.out.print("        ");
	     for (T i : claves) System.out.printf("%-8s", i.getNombre());
	     System.out.println();

	     for (T i : claves) { 
	         System.out.printf("%-8s", i.getNombre());
	         for (T j : claves) { 
	             INodo<T> nodoI = nodos.get(i);
	             INodo<T> nodoJ = nodos.get(j);
	             System.out.printf("%-8s", nodoI.getVecinos().contains(nodoJ) ? "1" : "0");
	         }
	         System.out.println();
	     }
	 }
	
	public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) {
        	System.out.println("El nodo " + inicio + " no existe en el grafo.");
        	return;
        }

        Set<T> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();
        INodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS desde " + inicio + ":");
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getDato().getNombre() + " ");
            for (INodo<T> vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getDato())) {
                    visitados.add(vecino.getDato());
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) {
        	System.out.println("El nodo " + inicio + " no existe en el grafo.");
        	return;
        }
        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + inicio + ":");
        dfsRecursivo(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRecursivo(INodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.print(actual.getDato().getNombre() + " ");
        for (INodo<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getDato())) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }
}