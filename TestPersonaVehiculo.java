package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestPersonaVehiculo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona p = new Persona(1111, "Juan Martinez");//Se crea la lista nula!!
		Vehiculo v1 = new Vehiculo("11AA111", "Fiat Uno");
		Vehiculo v2 = new Vehiculo("22BB222", "Fiat Cronos");
		//Vehiculo v3 = new Vehiculo("33CC333", "Toyota Yaris");
		
		p.getListaVehiculos().insertarPrimero(v1);
		p.getListaVehiculos().insertarUltimo(v2);
		//l.insertarGenerico(v3, 1);
		
		p.getListaVehiculos().insertarPrimero(v1);
		
		//Muestro la persona, y sus vehiculos concatenados
		//Atentos a cómo manejo el toString de ambos y los
		//procedimientos de mostrar. 
		p.mostrarPersona();
		System.out.println(p);
		System.out.println(v1);
		System.out.println(p.getListaVehiculos());
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
