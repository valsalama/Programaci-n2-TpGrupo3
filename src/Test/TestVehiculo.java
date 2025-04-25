package test;

import modelo.Vehiculo;

public class TestVehiculo {

    public static void main(String[] args) {
        // Crear vehículos
        Vehiculo v1 = new Vehiculo("Fiat Uno", "11AA11");
        Vehiculo v2 = new Vehiculo("Toyota Hilux", "22BB222");

        // Mostrar vehículos
        System.out.println("Vehículo 1: " + v1);
        System.out.println("Vehículo 2: " + v2);

        // Modificar atributos
        v1.setModelo("Fiat Punto");
        v2.setPatente("33CC333");

        // Mostrar vehículos modificados
        System.out.println("Vehículo 1 modificado: " + v1);
        System.out.println("Vehículo 2 modificado: " + v2);
    }
}