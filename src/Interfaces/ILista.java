package Interfaces;

import Modelos.Vehiculo;

public interface ILista {
	
    // Primitivas de la lista, métodos elementales de la estrucutra
    // Para insertar
    public void insertarPrimero(Vehiculo a);
    public void insertarUltimo(Vehiculo a); // Método de cola o pila
    public void insertarGenerico(Vehiculo a, int pos);
	
    // Para eliminar
    public Vehiculo eliminarPrimero(); // Método de cola
    public Vehiculo eliminarUltimo(); // Método de pila
    public Vehiculo eliminarGenerico(int pos);
	
    // Para obtener
    public Vehiculo obtenerPrimero(); // Método de cola
    public Vehiculo obtenerUltimo(); // Método de pila
    public Vehiculo obtenerGenerico(int pos);
	
    // Métodos extras
    public boolean esVacia();
    public int cantidadElementos();
    public void ordenar();
    public void mostrar();
    public int buscar(Vehiculo a);
}
