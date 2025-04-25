package Modelos;

import Interfaces.INodo;

public class Nodo implements INodo {

	private Vehiculo dato;
    private INodo siguiente;
    private INodo anterior;

    // Contructor
	public Nodo(Vehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    // Getter y Setters
    // Datos
    public Vehiculo getDato() {
        return dato;
    }
    public void setDato(Vehiculo dato) {
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
		return "Nodo [dato=" + dato + ", siguiente=" + siguiente + ", anterior=" + anterior + "]";
	}	
}