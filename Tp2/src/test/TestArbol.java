package test;

import model.Arbol;
import model.Persona;

public class TestArbol {

    public static void main(String[] args) {
        // Crear árbol
        System.out.println("=== CREACIÓN DEL ÁRBOL ===");
        Arbol arbol = new Arbol();
        System.out.println("Árbol creado. Raíz: " + arbol.getRaiz());

        // Crear personas para insertar
        Persona p1 = new Persona(12345678, "Juan");
        Persona p2 = new Persona(87654321, "Ana");
        Persona p3 = new Persona(11111111, "Zoe");
        Persona p4 = new Persona(22222222, "Carlos");
        Persona p5 = new Persona(33333333, "Maria");

        // Insertar personas en el árbol
        System.out.println("\n=== INSERTANDO PERSONAS EN EL ÁRBOL ===");
        arbol.insertar(p1);
        System.out.println("Insertado: " + p1.getNombre());
        
        arbol.insertar(p2);
        System.out.println("Insertado: " + p2.getNombre());
        
        arbol.insertar(p3);
        System.out.println("Insertado: " + p3.getNombre());
        
        arbol.insertar(p4);
        System.out.println("Insertado: " + p4.getNombre());
        
        arbol.insertar(p5);
        System.out.println("Insertado: " + p5.getNombre());

        // Mostrar información del árbol
        System.out.println("\n=== INFORMACIÓN DEL ÁRBOL ===");
        System.out.println("Raíz del árbol: " + arbol.getRaiz().getDato().getNombre());
        
        if (arbol.getRaiz().getIzquierda() != null) {
            System.out.println("Hijo izquierdo de la raíz: " + 
                             arbol.getRaiz().getIzquierda().getDato().getNombre());
        }
        
        if (arbol.getRaiz().getDerecha() != null) {
            System.out.println("Hijo derecho de la raíz: " + 
                             arbol.getRaiz().getDerecha().getDato().getNombre());
        }

        // Probar eliminación
        System.out.println("\n=== ELIMINANDO PERSONAS DEL ÁRBOL ===");
        System.out.println("Eliminando: " + p2.getNombre());
        arbol.eliminar(p2);
        
        System.out.println("Eliminando: " + p4.getNombre());
        arbol.eliminar(p4);

        // Mostrar estado después de eliminaciones
        System.out.println("\n=== ESTADO DESPUÉS DE ELIMINACIONES ===");
        System.out.println("Raíz del árbol: " + arbol.getRaiz().getDato().getNombre());
    }
}
