package interfaz;

import modelo.Vehiculo;

public interface ILista {
  //Métodos
		public INodo getPrimero();
		public void setPrimero(INodo primero);
		@Override
		public String toString();
		
		///Primitivas de la lista, métodos elementales de la estrucutra
		
		//Para insertar
		public void insertarPrimero(Vehiculo a);
		public void insertarUltimo(Vehiculo a); //metodo de cola o pila
		public void insertarGenerico(Vehiculo a, int pos);
		
		//Para eliminar
		//puede retornar el nodo o el dato eliminado, como queira 
		public Vehiculo eliminarPrimero(); //metodo de cola
		public Vehiculo eliminarUltimo(); //metodo de pila
		public Vehiculo eliminarGenerico(int pos);
		
		//Para obtener
		public Vehiculo obtenerPrimero(); //metood de cola
		public Vehiculo obtenerUltimo(); //metodo de pila
		public Vehiculo obtenerGenerico(int pos);
		
		//Métodos extras
		public boolean esVacia();
		public int cantidadElementos();
		public void ordenar();
		public void mostrar();
		public int buscar(Vehiculo a);
}
