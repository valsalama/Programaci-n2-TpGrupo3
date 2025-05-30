package interfaz;

import model.Nodo;
import model.Persona;

public interface INodo {
	
	public Persona getDato();
	public void setDato(Persona dato);
	public Nodo getIzquierda();
	public void setIzquierda(Nodo izquierda);
	public Nodo getDerecha();
	public void setDerecha(Nodo derecha);
	public String toString();
}
