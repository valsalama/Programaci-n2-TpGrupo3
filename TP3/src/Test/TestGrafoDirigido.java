package test;

import interfaz.IGrafo;
import interfaz.IGrafoGenerico;
import interfaz.IPersona;
import modelo.Grafo;
import modelo.GrafoGenerico;
import modelo.Persona;

public class TestGrafoDirigido {

	public static void main(String[] args) {
		
		System.out.println("=== PRUEBA CON GRAFO NO DIRIGIDO ===");
		testGrafoNodirigido();
		
		System.out.println("\n=== PRUEBA CON GRAFO DIRIGIDO ===");
		testGrafoDirigido();
		
		System.out.println("\n=== PRUEBA CON GRAFO GENÉRICO (Object) ===");
		testGrafoGenerico();
	}
	
	private static void testGrafoNodirigido() {
		IGrafo<IPersona> grafo = new Grafo<>(false); 
        
		IPersona p1 = new Persona("Juan", 32546);
		IPersona p2 = new Persona("Sofia", 49799);
		IPersona p3 = new Persona("Julian", 48923);
		IPersona p4 = new Persona("Agustin", 32567);
		
		grafo.agregarNodo(p1);
		grafo.agregarNodo(p2);
		grafo.agregarNodo(p3);
		grafo.agregarNodo(p4);
		
		grafo.agregarArista(p1, p2, 5);
		grafo.agregarArista(p2, p3, 3);
		grafo.agregarArista(p3, p4, 2);
		grafo.agregarArista(p4, p1, 4);
		
		grafo.mostrarListaAdyacencia();
		grafo.mostrarMatrizAdyacencia();
		grafo.bfs(p1);
		grafo.dfs(p1);
	}
	
	private static void testGrafoDirigido() {
		IGrafo<IPersona> grafo = new Grafo<>(true); // Dirigido
		
		IPersona p1 = new Persona("Ana", 11111);
		IPersona p2 = new Persona("Bob", 22222);
		IPersona p3 = new Persona("Carlos", 33333);
		IPersona p4 = new Persona("Diana", 44444);
		
		grafo.agregarNodo(p1);
		grafo.agregarNodo(p2);
		grafo.agregarNodo(p3);
		grafo.agregarNodo(p4);
		
		// En un grafo dirigido, las aristas van en una sola dirección
		grafo.agregarArista(p1, p2, 5);  // Ana -> Bob
		grafo.agregarArista(p2, p3, 3);  // Bob -> Carlos
		grafo.agregarArista(p3, p4, 2);  // Carlos -> Diana
		grafo.agregarArista(p4, p1, 4);  // Diana -> Ana
		grafo.agregarArista(p1, p3, 7);  // Ana -> Carlos (directo)
		
		grafo.mostrarListaAdyacencia();
		grafo.mostrarMatrizAdyacencia();
		grafo.bfs(p1);
		grafo.dfs(p1);
	}
	
	private static void testGrafoGenerico() {
		// Grafo genérico que puede contener cualquier tipo de objeto
		IGrafoGenerico<String> grafoString = new GrafoGenerico<>(true);
		
		grafoString.agregarNodo("A");
		grafoString.agregarNodo("B");
		grafoString.agregarNodo("C");
		grafoString.agregarNodo("D");
		
		grafoString.agregarArista("A", "B", 1);
		grafoString.agregarArista("B", "C", 2);
		grafoString.agregarArista("C", "D", 3);
		grafoString.agregarArista("A", "D", 4);
		
		grafoString.mostrarListaAdyacencia();
		grafoString.mostrarMatrizAdyacencia();
		grafoString.bfs("A");
		grafoString.dfs("A");
		
		// También se puede usar con números
		IGrafoGenerico<Integer> grafoNumeros = new GrafoGenerico<>(false);
		grafoNumeros.agregarNodo(1);
		grafoNumeros.agregarNodo(2);
		grafoNumeros.agregarNodo(3);
		
		grafoNumeros.agregarArista(1, 2, 10);
		grafoNumeros.agregarArista(2, 3, 20);
		
		System.out.println("\nGrafo de números:");
		grafoNumeros.mostrarListaAdyacencia();
		grafoNumeros.bfs(1);
	}
}
