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
	
	public Map<T, INodo<T>> getNodos() {
		return nodos;
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
            nodoDestino.agregarVecino(nodoOrigen, peso);
		}
	}
	
	public void mostrarListaAdyacencia() {
		System.out.println("Lista de Adyacencia:");
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
	     System.out.println("Matriz de Adyacencia:");
	     List<T> claves = new ArrayList<>(nodos.keySet());
	     Collections.sort( claves); 
	     System.out.print("   ");
	     for (T i : claves) System.out.print(i + " ");
	     System.out.println();

	     for (T i : claves) { 
	         System.out.print(i + ": ");
	         for (T j : claves) { 
	             INodo<T> nodoI = nodos.get(i);
	             INodo<T> nodoJ = nodos.get(j);
	             System.out.print(nodoI.getVecinos().contains(nodoJ) ? "1 " : "0 ");
	         }
	         System.out.println();
	     }
	 }
	
	public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) {
        	return;
        }

        Set<T> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();
        INodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");
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
        if (!nodos.containsKey(inicio)) return;
        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRecursivo(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRecursivo(INodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.print(actual.getDato() + " ");
        for (INodo<T> vecino : actual.getVecinos()) {
            if (!visitados.contains(vecino.getDato())) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }
}
