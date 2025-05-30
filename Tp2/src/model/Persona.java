package Modelo;

import Interfaz.IPersona;

public class Persona implements Comparable<IPersona> , IPersona {
	
	private int dni;
	private String nombre;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}
	public Persona(int dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}
	@Override
	public int compareTo(IPersona p) {
		int comparar = this.nombre.compareTo(p.getNombre());
		if (comparar == 0) {
			if (dni < p.getDni()) {
				return -1;
			}
			if (dni > p.getDni()) {
				return 1;
			}
			else {
				return 0;
			}
		}
		return comparar;
	}
}
