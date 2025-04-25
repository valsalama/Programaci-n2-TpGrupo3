package interfaz;

public interface ILista {

	// Primitivas de la lista, métodos elementales de la estrucutra
	// Para insertar
	public void insertarPrimero(IVehiculo a);

	public void insertarUltimo(IVehiculo a); // Método de cola

	public void insertarGenerico(IVehiculo a, int pos);

	// Para eliminar, devuelven el dato eliminado
	public IVehiculo eliminarPrimero(); // Método de cola

	public IVehiculo eliminarUltimo(); // Método de pila

	public IVehiculo eliminarGenerico(int pos);

	// Para obtener
	public IVehiculo obtenerPrimero(); // Método de cola

	public IVehiculo obtenerUltimo(); // Método de pila

	public IVehiculo obtenerGenerico(int pos);

	// Métodos extras
	public boolean esVacia();

	public int cantidadElementos();

	public void ordenar();

	public void mostrar();

	public int buscar(IVehiculo a);
}