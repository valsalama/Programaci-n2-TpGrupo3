package test;

import model.Nodo;
import model.Persona;

public class TestNodo {

    public static void main(String[] args) {
        // Crear personas para los nodos
        Persona p1 = new Persona(12345678, "Juan Perez");
        Persona p2 = new Persona(87654321, "Ana Lopez");
        Persona p3 = new Persona(11111111, "Zoe Martinez");

        // Crear nodos
        System.out.println("=== CREACIÓN DE NODOS ===");
        Nodo nodo1 = new Nodo(p1);
        Nodo nodo2 = new Nodo(p2);
        Nodo nodo3 = new Nodo(p3);

        System.out.println("Nodo 1: " + nodo1.getDato());
        System.out.println("Nodo 2: " + nodo2.getDato());
        System.out.println("Nodo 3: " + nodo3.getDato());

        // Establecer relaciones entre nodos
        System.out.println("\n=== ESTABLECIENDO RELACIONES ===");
        nodo1.setIzquierda(nodo2);
        nodo1.setDerecha(nodo3);

        System.out.println("Nodo raíz: " + nodo1.getDato().getNombre());
        System.out.println("Hijo izquierdo: " + nodo1.getIzquierda().getDato().getNombre());
        System.out.println("Hijo derecho: " + nodo1.getDerecha().getDato().getNombre());

        // Mostrar estructura completa
        System.out.println("\n=== ESTRUCTURA COMPLETA ===");
        System.out.println("Nodo completo: " + nodo1);

        // Modificar datos del nodo
        System.out.println("\n=== MODIFICANDO DATOS ===");
        Persona nuevaPersona = new Persona(99999999, "Pedro Rodriguez");
        nodo1.setDato(nuevaPersona);
        System.out.println("Nodo modificado: " + nodo1.getDato());
    }
}