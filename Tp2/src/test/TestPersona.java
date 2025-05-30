package test;

import model.Persona;

public class TestPersona {

    public static void main(String[] args) {
        // Crear personas
        Persona p1 = new Persona(12345678, "Juan Perez");
        Persona p2 = new Persona(87654321, "Maria Lopez");
        Persona p3 = new Persona(11111111, "Carlos Gomez");

        // Mostrar información inicial de las personas
        System.out.println("=== INFORMACIÓN INICIAL DE LAS PERSONAS ===");
        System.out.println("Persona 1: " + p1);
        System.out.println("Persona 2: " + p2);
        System.out.println("Persona 3: " + p3);

        // Modificar atributos
        System.out.println("\n=== MODIFICANDO ATRIBUTOS ===");
        p1.setNombre("Juan Carlos Perez");
        p2.setDni(99999999);

        System.out.println("Persona 1 modificada: " + p1);
        System.out.println("Persona 2 modificada: " + p2);

        // Probar comparaciones
        System.out.println("\n=== PRUEBAS DE COMPARACIÓN ===");
        System.out.println("Comparando " + p1.getNombre() + " con " + p2.getNombre() + ": " + p1.compareTo(p2));
        System.out.println("Comparando " + p2.getNombre() + " con " + p1.getNombre() + ": " + p2.compareTo(p1));
        
        // Crear personas con mismo nombre para probar comparación por DNI
        Persona p4 = new Persona(22222222, "Ana");
        Persona p5 = new Persona(33333333, "Ana");
        
        System.out.println("Comparando personas con mismo nombre:");
        System.out.println(p4.getNombre() + " (DNI: " + p4.getDni() + ") con " + 
                          p5.getNombre() + " (DNI: " + p5.getDni() + "): " + p4.compareTo(p5));
    }
}
