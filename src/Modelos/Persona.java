package Modelos;

import Interfaces.IPersona;

public class Persona implements IPersona {
	
	private String nombre;
	private int dni;
	private Lista listaVehiculos;

    // Constructor
	public Persona(String nombre, int dni) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.listaVehiculos = new Lista(); // Se crea la lista
	}
	
    // Getter y Setters
    // Nombre
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    // Dni
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}

    // Lista de Vehiculos
    public Lista getListaVehiculos() {
        return listaVehiculos;
    }
    public void setListaVehiculos(Lista lista) {
        this.listaVehiculos = lista;
    }
	
    // Mostrar vehiculos
	public void mostrarPersona() {
		System.out.println(this);
		listaVehiculos.mostrar();
	}

    // String
	@Override
	public String toString() {
		return "Persona [ nombre= " + nombre + ", dni= " + dni + " ]";
	}
}