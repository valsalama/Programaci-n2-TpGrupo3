package interfaz;


public interface ILista {
	
	//Métodos
		public INodo getPrimero();
		public void setPrimero(INodo primero);
		@Override
		public String toString();
		
		///Primitivas de la lista, métodos elementales de la estrucutra
		
		//Para insertar
		public void insertarPrimero(IVehiculo a);
		public void insertarUltimo(IVehiculo a); //metodo de cola o pila
		public void insertarGenerico(IVehiculo a, int pos);
		
		//Para eliminar
		//puede retornar el nodo o el dato eliminado, como queira 
		public IVehiculo eliminarPrimero(); //metodo de cola
		public IVehiculo eliminarUltimo(); //metodo de pila
		public IVehiculo eliminarGenerico(int pos);
		
		//Para obtener
		public IVehiculo obtenerPrimero(); //metood de cola
		public int obtenerUltimo(); //metodo de pila
		public IVehiculo obtenerGenerico(int pos);
		
		//Métodos extras
		public boolean esVacia();
		public int cantidadElementos();
		public void ordenar();
		public void mostrar();
		public int buscar(IVehiculo a);
}

