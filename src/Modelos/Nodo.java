package modelo;

import interfaz.INodo;
import interfaz.IVehiculo;

public class Nodo implements INodo {

	private IVehiculo dato;
    private INodo siguiente; //INodo
    private INodo anterior;

    public INodo getAnterior() {
		return anterior;
	}
	public void setAnterior(INodo anterior) {
		this.anterior = anterior;
	}
	public Nodo(IVehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    public IVehiculo getDato() {
        return dato;
    }
    public void setDato(IVehiculo dato) {
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
		return "Nodo [dato=" + dato + ", anterior=" + anterior + "]";
	}
	
}
