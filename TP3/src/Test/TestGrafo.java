package test;

import interfaz.IGrafo;
import interfaz.IPersona;
import modelo.Grafo;
import modelo.Persona;

public class TestGrafo {

	public static void main(String[] args) {
		
		System.out.println("=== PRUEBA COMPLETA DEL GRAFO CON PERSONAS ===");
		
		// Crear el grafo (por defecto es no dirigido)
		IGrafo<IPersona> grafo = new Grafo<>();
		
		System.out.println("Creando personas para el grafo:");
		IPersona p1 = new Persona("Juan", 32546);
		IPersona p2 = new Persona("Sofia", 49799);
		IPersona p3 = new Persona("Julian", 48923);
		IPersona p4 = new Persona("Agustin", 32567);
		IPersona p5 = new Persona("Renata", 98662);
		IPersona p6 = new Persona("Juliana", 32556);
		IPersona p7 = new Persona("Hector", 87789);
		
		System.out.println("   - " + p1);
		System.out.println("   - " + p2);
		System.out.println("   - " + p3);
		System.out.println("   - " + p4);
		System.out.println("   - " + p5);
		System.out.println("   - " + p6);
		System.out.println("   - " + p7);
		
		System.out.println("Agregando aristas (conexiones) entre personas:");
		
		// Conexiones con sus respectivos pesos (pueden representar distancia, costo, etc.)
		grafo.agregarArista(p6, p7, 3);    // Juliana <-> Hector (peso 3)
		System.out.println("   - Juliana <-> Hector (peso: 3)");
		
		grafo.agregarArista(p1, p1, 0);    // Juan <-> Juan (bucle, peso 0)
		System.out.println("   - Juan <-> Juan (bucle, peso: 0)");
		
		grafo.agregarArista(p5, p2, 2);    // Renata <-> Sofia (peso 2)
		System.out.println("   - Renata <-> Sofia (peso: 2)");
		
		grafo.agregarArista(p5, p4, 0);    // Renata <-> Agustin (peso 0)
		System.out.println("   - Renata <-> Agustin (peso: 0)");
		
		grafo.agregarArista(p5, p7, 5);    // Renata <-> Hector (peso 5)
		System.out.println("   - Renata <-> Hector (peso: 5)");
		
		grafo.agregarArista(p3, p2, 0);    // Julian <-> Sofia (peso 0)
		System.out.println("   - Julian <-> Sofia (peso: 0)");
		
		grafo.agregarArista(p6, p2, 2);    // Juliana <-> Sofia (peso 2)
		System.out.println("   - Juliana <-> Sofia (peso: 2)");
		
		grafo.agregarArista(p5, p1, 10);   // Renata <-> Juan (peso 10)
		System.out.println("   - Renata <-> Juan (peso: 10)");
		
		grafo.agregarArista(p4, p3, 4);    // Agustin <-> Julian (peso 4)
		System.out.println("   - Agustin <-> Julian (peso: 4)");
		
		grafo.agregarArista(p6, p4, 8);    // Juliana <-> Agustin (peso 8)
		System.out.println("   - Juliana <-> Agustin (peso: 8)");
		
		System.out.println("   ✓ Todas las aristas agregadas exitosamente");
		
		System.out.println("VISUALIZACIÓN DEL GRAFO");
		
		// Mostrar lista de adyacencia
		System.out.println("\n📋 LISTA DE ADYACENCIA:");
		System.out.println("(Muestra cada nodo y sus vecinos con pesos)");
		grafo.mostrarListaAdyacencia();
		
		// Mostrar matriz de adyacencia
		System.out.println("\n📊 MATRIZ DE ADYACENCIA:");
		System.out.println("(1 = hay conexión, 0 = no hay conexión)");
		grafo.mostrarMatrizAdyacencia();
		
		// ===== RECORRIDOS DEL GRAFO =====
		System.out.println("RECORRIDOS DEL GRAFO");
		
		// Recorrido BFS (Breadth-First Search)
		System.out.println("\n🔍 RECORRIDO BFS (Búsqueda en Anchura):");
		System.out.println("Comenzando desde Sofia:");
		System.out.println("(Visita primero todos los vecinos directos, luego los vecinos de los vecinos)");
		grafo.bfs(p2);
		
		// Recorrido DFS (Depth-First Search)
		System.out.println("\n🔍 RECORRIDO DFS (Búsqueda en Profundidad):");
		System.out.println("Comenzando desde Agustin:");
		System.out.println("(Va tan profundo como sea posible antes de retroceder)");
		grafo.dfs(p4);
		
		System.out.println("PRUEBAS ADICIONALES");
		
		// Probar BFS desde diferentes nodos
		System.out.println("\n🔍 BFS desde Juan (nodo con bucle):");
		grafo.bfs(p1);
		
		System.out.println("\n🔍 DFS desde Renata (nodo más conectado):");
		grafo.dfs(p5);
		
		// Probar con nodo que no existe
		System.out.println("\n❌ Intentando BFS desde un nodo inexistente:");
		IPersona personaInexistente = new Persona("NoExiste", 99999);
		grafo.bfs(personaInexistente);
	}
}
