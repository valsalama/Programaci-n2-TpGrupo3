package test;

import modelo.Lista;
import modelo.Persona;
import modelo.Vehiculo;

public class TestPersonaVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona p = new Persona(1111, "Juan Martinez");//Se crea la lista nula!!
		Lista l = p.getListaVehiculos();
		Vehiculo v1 = new Vehiculo("11AA111", "Fiat Uno");
		Vehiculo v2 = new Vehiculo("22BB222", "Toyota Hylux");
		Vehiculo v3 = new Vehiculo("33CC333", "Toyota Yaris");
		Vehiculo v4 = new Vehiculo("44DD444", "Peugeot 208");
		Vehiculo v5 = new Vehiculo("55EE555", "Volkswagen Polo");
		
		l.insertarPrimero(v1);
		l.insertarUltimo(v3);
		l.insertarGenerico(v2, 1); //no funciona
		l.insertarUltimo(v2);
		l.insertarUltimo(v5);
		l.insertarGenerico(v4, 3); //no funciona
		
		p.mostrarPersona();
		System.out.println("");
		
		System.out.println("Posición del Fiat Uno: " + l.buscar(v1));
		System.out.println("Cantidad de vehiculos: " + l.cantidadElementos());
		System.out.println("Primer elemento: " + l.obtenerPrimero());
		System.out.println("Elemento en posición 1: " + l.obtenerGenerico(1));
		System.out.println("");
		
		System.out.println("Lista vehiculos ordenada por patentes");
		l.ordenar();
		p.mostrarPersona();
		System.out.println("");
		
		System.out.println("Se elimino el vehiculo en posición 1: " + l.eliminarGenerico(1)); //no funciona
		p.mostrarPersona();
		System.out.println("");
		
		System.out.println("Se elimino el primer vehiculo: " + l.eliminarPrimero());
		p.mostrarPersona();
		System.out.println("");
		
		System.out.println("Se elimino el ultimo vehiculo: " + l.eliminarUltimo()); //no funciona
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
