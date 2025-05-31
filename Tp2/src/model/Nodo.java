package model;

import interfaz.INodo;
import interfaz.IPersona;

public class Nodo<T extends IPersona> implements INodo<T>{
	
	private T dato;
	private INodo<T> izquierda;
	private INodo<T> derecha;
	
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
		
	}
	public INodo<T> getIzquierda() {
		return izquierda;
	}
	public void setIzquierda(INodo<T> izquierda) {
		this.izquierda = izquierda;
	}
	public INodo<T> getDerecha() {
		return derecha;
	}
	public void setDerecha(INodo<T> derecha) {
		this.derecha = derecha;
	}
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", izquierda=" + izquierda + ", derecha=" + derecha + "]";
	}
	public Nodo(T dato) {
		super();
		this.dato = dato;
		this.izquierda = null;
		this.derecha = null;
	}
}
