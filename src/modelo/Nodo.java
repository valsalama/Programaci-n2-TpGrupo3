package modelo;

import interfaz.INodo;
import interfaz.IVehiculo;

public class Nodo implements INodo {

	private IVehiculo dato;
    private INodo siguiente;
    private INodo anterior;

    // Constructor
	public Nodo(IVehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    // Getters y Setters
    // Dato
    public IVehiculo getDato() {
        return dato;
    }
    public void setDato(IVehiculo dato) {
        this.dato = dato;
    }
    // Anterior
    public INodo getAnterior() {
		return anterior;
	}
	public void setAnterior(INodo anterior) {
		this.anterior = anterior;
	}

    // Siguiente
    public INodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(INodo nodo) {
        this.siguiente = nodo;
    }

    // String
	@Override
	public String toString() {
		return "Nodo [ dato= " + dato + ", anterior= " + anterior + " ]";
	}	
}