package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestIntegracion {

    public static void main(String[] args) {
        // Crear persona
        Persona persona = new Persona("Ana Lopez", 22222);

        // Crear vehículos
        Vehiculo v1 = new Vehiculo("Ford Fiesta", "66FF666");
        Vehiculo v2 = new Vehiculo("Chevrolet Cruze", "77GG777");

        // Agregar vehículos a la lista de la persona
        persona.getListaVehiculos().insertarPrimero(v1);
        persona.getListaVehiculos().insertarUltimo(v2);

        // Mostrar información de la persona y sus vehículos
        persona.mostrarPersona();

        // Eliminar un vehículo
        persona.getListaVehiculos().eliminarPrimero();

        // Mostrar información actualizada
        persona.mostrarPersona();
    }
}