package modelo;

import java.util.Objects;

import interfaces.INodo;

public class Nodo implements INodo {
    private String nombre;

    public Nodo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Nodo nodo = (Nodo) obj;
        return Objects.equals(nombre, nodo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}

