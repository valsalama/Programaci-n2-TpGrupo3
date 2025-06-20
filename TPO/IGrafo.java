package interfaces;

import java.util.List;

import modelo.Vertice;

public interface IGrafo {


	void agregarVertice(Vertice vertice);
	/**
	 * Pre: El vertice no debe existir previamente en el grafo.
	 * Post: El grafo contiene el nuevo vertice agregado.
	 * Axioma: La cantidad de vertices aumenta en uno.
	 */

	void agregarArista(String origen, String destino, double peso);
	/**
	 * Pre: Ambos vertices (origen y destino) existen en el grafo.
	 * Post: Se añade una arista dirigida desde origen hacia destino con el peso especificado.
	 * Axioma: El grafo refleja la nueva conexion con el peso indicado.
	 */

	boolean existeVertice(String vertice);
	/**
	 * Pre: Ninguna.
	 * Post: Devuelve true si el vertice existe en el grafo; false en caso contrario.
	 * Axioma: La existencia se basa en la presencia en la estructura interna.
	 */

	double getPesoArista(String origen, String destino);
	/**
	 * Pre: Los vertices existen en el grafo y estan conectados por una arista directa.
	 * Post: Retorna el peso asociado a la arista entre origen y destino.
	 * Axioma: El peso es un valor numerico positivo o cero (si se permite).
	 */

	List<String> dijkstra(String origen, String destino);
	/**
	 * Pre: Los vertices origen y destino existen en el grafo y hay al menos un camino entre ellos.
	 * Post: Devuelve una lista ordenada con los nombres de los vertices que conforman la ruta minima.
	 * Axioma: La ruta calculada minimiza la suma de pesos entre origen y destino.
	 */

}

