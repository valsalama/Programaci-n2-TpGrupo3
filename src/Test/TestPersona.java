package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestPersona {

    public static void main(String[] args) {
        // Crear persona
        Persona persona = new Persona("Carlos Gomez", 98765);

        // Mostrar información inicial de la persona
        System.out.println("Información inicial de la persona:");
        System.out.println(persona);

        // Crear vehículos
        Vehiculo vehiculo1 = new Vehiculo("Ford Focus", "ABC123");
        Vehiculo vehiculo2 = new Vehiculo("Chevrolet Onix", "XYZ789");

        // Agregar vehículos a la lista de la persona
        persona.getListaVehiculos().insertarPrimero(vehiculo1);
        persona.getListaVehiculos().insertarUltimo(vehiculo2);

        // Mostrar información de la persona y sus vehículos
        System.out.println("\nInformación de la persona y sus vehículos:");
        persona.mostrarPersona();

        // Eliminar un vehículo
        // Se elimina el primer vehículo de la lista de la persona.
        System.out.println("\nEliminando el primer vehículo...");
        persona.getListaVehiculos().eliminarPrimero();

        // Mostrar información actualizada
        System.out.println("\nInformación actualizada de la persona y sus vehículos:");
        persona.mostrarPersona();
    }
}