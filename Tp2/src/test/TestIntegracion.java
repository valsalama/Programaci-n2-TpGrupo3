package test;

import interfaz.INodo;
import model.Arbol;
import model.Persona;

public class TestIntegracion {

    public static void main(String[] args) {
        System.out.println("=== TEST DE INTEGRACIÓN - ÁRBOL BINARIO ===");
        
        // Crear árbol
        Arbol arbol = new Arbol();
        System.out.println("Árbol creado");
        
        // Crear personas
        Persona p1 = new Persona(12345678, "Juan");
        Persona p2 = new Persona(87654321, "Ana");
        Persona p3 = new Persona(11111111, "Zoe");
        Persona p4 = new Persona(22222222, "Carlos");

        // Insertar personas
        System.out.println("\n=== INSERTANDO PERSONAS ===");
        arbol.insertar(p1);
        System.out.println("Insertado: " + p1.getNombre());
        
        arbol.insertar(p2);
        System.out.println("Insertado: " + p2.getNombre());
        
        arbol.insertar(p3);
        System.out.println("Insertado: " + p3.getNombre());
        
        arbol.insertar(p4);
        System.out.println("Insertado: " + p4.getNombre());

        // Mostrar información básica del árbol
        System.out.println("\n=== INFORMACIÓN DEL ÁRBOL ===");
        System.out.println("Raíz: " + arbol.getRaiz().getDato().getNombre());
        
        if (arbol.getRaiz().getIzquierda() != null) {
            System.out.println("Hijo izquierdo de la raíz: " + 
                             arbol.getRaiz().getIzquierda().getDato().getNombre());
        } else {
            System.out.println("No hay hijo izquierdo");
        }
        
        if (arbol.getRaiz().getDerecha() != null) {
            System.out.println("Hijo derecho de la raíz: " + 
                             arbol.getRaiz().getDerecha().getDato().getNombre());
        } else {
            System.out.println("No hay hijo derecho");
        }

        // Probar búsqueda
        System.out.println("\n=== PROBANDO BÚSQUEDA ===");
        INodo encontrado = arbol.buscar(p2);
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getDato().getNombre());
        } else {
            System.out.println("No se encontró a " + p2.getNombre());
        }

        // Probar recorridos
        System.out.println("\n=== RECORRIDO INORDEN ===");
        arbol.recorridoInorden();
        
        System.out.println("\n\n=== RECORRIDO PREORDEN ===");
        arbol.recorridoPreorden();
        
        System.out.println("\n\n=== RECORRIDO POSTORDEN ===");
        arbol.recorridoPostorden();

        // Eliminar una persona
        System.out.println("\n\n=== ELIMINANDO PERSONA ===");
        System.out.println("Eliminando: " + p2.getNombre());
        arbol.eliminar(p2);
        
        System.out.println("Recorrido después de eliminar:");
        arbol.recorridoInorden();

        // Probar encontrar mínimo
        System.out.println("\n\n=== ENCONTRAR MÍNIMO ===");
        INodo minimo = arbol.encontrarMinimo(arbol.getRaiz());
        if (minimo != null) {
            System.out.println("Mínimo: " + minimo.getDato().getNombre());
        } else {
            System.out.println("No se pudo encontrar el mínimo");
        }
    }
}
