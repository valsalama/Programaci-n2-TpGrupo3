package Test;

import interfaz.IGrafo;
import interfaz.IPersona;
import modelo.Grafo;
import modelo.Persona;

public class TestGrafo {

	public static void main(String[] args) {
		
		IGrafo<IPersona> grafo = new Grafo<>();
		
		IPersona p1 = new Persona("Juan", 32546);
		IPersona p2 = new Persona("Sofia", 49799);
		IPersona p3 = new Persona("Julian", 48923);
		IPersona p4 = new Persona("Agustin", 32567);
		IPersona p5 = new Persona("Renata", 98662);
		IPersona p6 = new Persona("Juliana", 32556);
		IPersona p7 = new Persona("Hector", 87789);
		
		grafo.agregarNodo(p1);
		grafo.agregarNodo(p2);
		grafo.agregarNodo(p3);
		grafo.agregarNodo(p4);
		grafo.agregarNodo(p5);
		grafo.agregarNodo(p6);
		grafo.agregarNodo(p7);
		
		grafo.agregarArista(p6, p7, 3);
		grafo.agregarArista(p1, p1, 0);
		grafo.agregarArista(p5, p2, 2);
		grafo.agregarArista(p5, p4, 0);
		grafo.agregarArista(p5, p7, 5);
		grafo.agregarArista(p3, p2, 0);
		grafo.agregarArista(p6, p2, 2);
		grafo.agregarArista(p5, p1, 10);
		grafo.agregarArista(p4, p3, 4);
		grafo.agregarArista(p6, p4, 8);
		
		grafo.mostrarListaAdyacencia();
		grafo.mostrarMatrizAdyacencia();
		
		grafo.bfs(p2);
		grafo.dfs(p4);
	}
}
