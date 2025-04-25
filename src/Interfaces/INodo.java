package Interfaces;

import Modelos.Vehiculo;

public interface INodo {
	
    // Vehiculo
	public Vehiculo getDato();
	public void setDato(Vehiculo dato);
	
    // Siguiente
    public INodo getSiguiente();
	public void setSiguiente(INodo nodo);

    // Anterior
	public INodo getAnterior();
	public void setAnterior(INodo anterior);
}