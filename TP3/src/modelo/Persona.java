package modelo;

import interfaz.IPersona;

public class Persona implements IPersona {
	
	private String nombre;
	private int dni;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", dni=" + dni + "]";
	}
	public Persona(String nombre, int dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
	}
	@Override
	public int compareTo(IPersona o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
