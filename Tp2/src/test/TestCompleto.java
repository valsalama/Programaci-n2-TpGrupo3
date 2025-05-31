package test;

import model.Arbol;
import model.Nodo;
import model.Persona;

public class TestCompleto {

    public static void main(String[] args) {
        System.out.println("=== TEST COMPLETO DEL SISTEMA ===");
        
        // Test 1: Funcionalidad básica de Persona
        System.out.println("\n1. TESTING CLASE PERSONA");
        testPersona();
        
        // Test 2: Funcionalidad básica de Nodo
        System.out.println("\n2. TESTING CLASE NODO");
        testNodo();
        
        // Test 3: Funcionalidad básica de Árbol
        System.out.println("\n3. TESTING CLASE ÁRBOL");
        testArbol();
        
        // Test 4: Casos extremos
        System.out.println("\n4. TESTING CASOS EXTREMOS");
        testCasosExtremos();
    }

    private static void testPersona() {
        Persona p1 = new Persona(12345678, "Juan");
        Persona p2 = new Persona(12345678, "Juan"); // Mismos datos
        Persona p3 = new Persona(87654321, "Ana");
        
        System.out.println("Persona creada: " + p1);
        System.out.println("Comparación mismo nombre y DNI: " + p1.compareTo(p2));
        System.out.println("Comparación nombres diferentes: " + p1.compareTo(p3));
    }

    private static void testNodo() {
        Persona p = new Persona(12345678, "Juan");
        Nodo nodo = new Nodo(p);
        
        System.out.println("Nodo creado: " + nodo.getDato().getNombre());
        System.out.println("Hijo izquierdo: " + nodo.getIzquierda());
        System.out.println("Hijo derecho: " + nodo.getDerecha());
    }

    private static void testArbol() {
        Arbol arbol = new Arbol();
        
        // Insertar en orden específico para crear un árbol balanceado
        Persona[] personas = {
            new Persona(4, "Maria"),    // Raíz
            new Persona(2, "Carlos"),   // Izquierda
            new Persona(6, "Pedro"),    // Derecha
            new Persona(1, "Ana"),      // Izquierda-Izquierda
            new Persona(3, "Juan"),     // Izquierda-Derecha
            new Persona(5, "Laura"),    // Derecha-Izquierda
            new Persona(7, "Zoe")       // Derecha-Derecha
        };
        
        for (Persona p : personas) {
            arbol.insertar(p);
            System.out.println("Insertado: " + p.getNombre());
        }
        
        System.out.println("Raíz del árbol: " + arbol.getRaiz().getDato().getNombre());
    }

    private static void testCasosExtremos() {
        Arbol arbol = new Arbol();
        
        // Caso 1: Árbol vacío
        System.out.println("Árbol vacío - Raíz: " + arbol.getRaiz());
        
        // Caso 2: Un solo elemento
        Persona unica = new Persona(1, "Unica");
        arbol.insertar(unica);
        System.out.println("Un elemento - Raíz: " + arbol.getRaiz().getDato().getNombre());
        
        // Caso 3: Eliminar el único elemento
        arbol.eliminar(unica);
        System.out.println("Después de eliminar único elemento - Raíz: " + 
                          (arbol.getRaiz() != null ? arbol.getRaiz().getDato().getNombre() : "null"));
        
        // Caso 4: Insertar elementos con nombres idénticos pero DNI diferentes
        Persona p1 = new Persona(1, "Juan");
        Persona p2 = new Persona(2, "Juan");
        arbol.insertar(p1);
        arbol.insertar(p2);
        System.out.println("Insertados dos 'Juan' con DNI diferentes");
        System.out.println("Raíz: " + arbol.getRaiz().getDato().getNombre() + 
                          " (DNI: " + arbol.getRaiz().getDato().getDni() + ")");
    }
}