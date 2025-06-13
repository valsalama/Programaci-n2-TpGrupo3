package modelo;

import java.util.ArrayList;
import java.util.List;

import interfaz.INodo;

public class Nodo<T> implements INodo<T> {
	
	private T dato;
	private List<INodo<T>> vecinos;
	private List<Integer> pesos;
	
	public Nodo(T dato) {
		super();
		this.dato = dato;
		this.vecinos = new ArrayList<>();
		this.pesos = new ArrayList<>();
	}

	public T getDato() {
		return dato;
	}

	public List<INodo<T>> getVecinos() {
		return vecinos;
	}

	public List<Integer> getPesos() {
		return pesos;
	}
	
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", vecinos=" + vecinos + ", pesos=" + pesos + "]";
	}

	
	//Metodos
	
	public void agregarVecino(INodo<T> vecino, int peso) {
		vecinos.add(vecino);
		pesos.add(peso);
	}
}
