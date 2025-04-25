package test;

import interfaz.IPersona;
import interfaz.IVehiculo;
import modelo.Persona;
import modelo.Vehiculo;

public class TestPersonaVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IPersona p = new Persona(1111, "Juan Martinez");//Se crea la lista nula!!
		IVehiculo v1 = new Vehiculo("11AA111", "Fiat Uno");
		IVehiculo v2 = new Vehiculo("22BB222", "Toyota Hylux");
		IVehiculo v3 = new Vehiculo("33CC333", "Toyota Yaris");
		IVehiculo v4 = new Vehiculo("44DD444", "Peugeot 208");
		IVehiculo v5 = new Vehiculo("55EE555", "Volkswagen Polo");
		
		p.getListaVehiculos().insertarPrimero(v1);
		p.getListaVehiculos().insertarUltimo(v3);
		p.getListaVehiculos().insertarUltimo(v5);
		p.getListaVehiculos().insertarGenerico(v4, 3);
		p.getListaVehiculos().insertarGenerico(v2, 1);
		
		p.mostrarPersona();
		System.out.println("");
		
		System.out.println("Posición del Fiat Uno: " + p.getListaVehiculos().buscar(v1));
		System.out.println("Cantidad de vehiculos: " + p.getListaVehiculos().cantidadElementos());
		System.out.println("Primer elemento: " + p.getListaVehiculos().obtenerPrimero());
		System.out.println("Elemento en posición 1: " + p.getListaVehiculos().obtenerGenerico(1));
		System.out.println("");
		
		System.out.println("Lista vehiculos ordenada por patentes");
		p.getListaVehiculos().ordenar();
		p.mostrarPersona();
		System.out.println("");
		
		System.out.println("Se elimino el vehiculo en posición 1: " + p.getListaVehiculos().eliminarGenerico(1)); //no funciona
		p.mostrarPersona();
		System.out.println("");
		
		System.out.println("Se elimino el primer vehiculo: " + p.getListaVehiculos().eliminarPrimero());
		p.mostrarPersona();
		System.out.println("");
		
		System.out.println("Se elimino el ultimo vehiculo: " + p.getListaVehiculos().eliminarUltimo()); //no funciona
		p.mostrarPersona();
		System.out.println("");
		
		
		///Notar que toda la información quedó guardada en la persona
		///
		///NOTAS: 
		///esto es una ayuda para el tp1, pero tienen muchas cosas que mejorar
		///1 - Hacer y usar una lista doblemente enlazada
		///2 - Testear más metodos, incluso algunos sofisticados como 
		///ordenar y buscar vehiculos
		///3 - El nodo tiene que tener el anterior, ojo que eso modifica los métodos
		///4 - Yo omiti las interfaces para hacer más rapido el ejemplo
		///Ustedes tienen que poner las interfaces y usarlas bien
		///Ningún items es obligatorio, pero cuanto más completo más nota. 
	}
}
