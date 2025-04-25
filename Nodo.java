package modelo;

import interfaz.INodo;

public class Nodo implements INodo {

	private Vehiculo dato;
    private INodo siguiente; //INodo
    private INodo anterior;

    public INodo getAnterior() {
		return anterior;
	}
	public void setAnterior(INodo anterior) {
		this.anterior = anterior;
	}
	public Nodo(Vehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    public Vehiculo getDato() {
        return dato;
    }
    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }
    public INodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(INodo nodo) {
        this.siguiente = nodo;
    }
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", siguiente=" + siguiente + ", anterior=" + anterior + "]";
	}
	
}
