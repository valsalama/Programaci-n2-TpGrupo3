package test;

import interfaz.IPersona;
import interfaz.IVehiculo;
import modelo.Persona;
import modelo.Vehiculo;

public class TestPersonaVehiculo {

	public static void main(String[] args) {

		// Crear una persona
		IPersona p = new Persona("Juan Martinez", 11111);

		// Crear vehículos
		IVehiculo v1 = new Vehiculo("Fiat Uno", "11AA11");
		IVehiculo v2 = new Vehiculo("Toyota Hylux", "22BB222");
		IVehiculo v3 = new Vehiculo("Toyota Yaris", "33CC333");
		IVehiculo v4 = new Vehiculo("Peugeot 208", "44DD444");
		IVehiculo v5 = new Vehiculo("Volkswagen Polo", "55EE555");

		// Agregar vehículos a la lista de la persona
		// Los vehículos se agregan a la lista de vehículos que pertenece a la persona.
		p.getListaVehiculos().insertarPrimero(v1);
		p.getListaVehiculos().insertarUltimo(v3);
		p.getListaVehiculos().insertarUltimo(v5);
		p.getListaVehiculos().insertarGenerico(v4, 3);
		p.getListaVehiculos().insertarGenerico(v2, 1);

		// Mostrar información de la persona y sus vehículos
		// Se imprime la información de la persona junto con los vehículos asociados.
		p.mostrarPersona();
		System.out.println("");

		// Buscar un vehículo por patente
		System.out.println("Posición del Fiat Uno: " + p.getListaVehiculos().buscar(v1));

		// Cantidad de vehículos
		System.out.println("Cantidad de vehiculos: " + p.getListaVehiculos().cantidadElementos());

		// Obtener el vehículo
		System.out.println("Primer elemento: " + p.getListaVehiculos().obtenerPrimero());
		System.out.println("Elemento en posición 1: " + p.getListaVehiculos().obtenerGenerico(1));
		System.out.println("");

		// Ordenar la lista de vehículos por patente
		System.out.println("Lista vehiculos ordenada por patentes");
		p.getListaVehiculos().ordenar();
		p.mostrarPersona();
		System.out.println("");

		// Eliminar vehículos
		System.out.println("Se elimino el vehiculo en posición 1: " + p.getListaVehiculos().eliminarGenerico(1));
		p.mostrarPersona();
		System.out.println("");

		System.out.println("Se elimino el primer vehiculo: " + p.getListaVehiculos().eliminarPrimero());
		p.mostrarPersona();
		System.out.println("");

		System.out.println("Se elimino el ultimo vehiculo: " + p.getListaVehiculos().eliminarUltimo());
		p.mostrarPersona();
		System.out.println("");
	}
}
