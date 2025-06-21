package modelo;

import interfaz.IVertice;
import interfaz.IArista;
import java.util.List;
import java.util.ArrayList;

public class Vertice implements IVertice {
    private String nombre;
    private List<IArista> adyacentes;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.adyacentes = new ArrayList<>();
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
    public boolean agregarArista(IVertice destino, double peso) {
        if (destino == null) return false;
        
        // Verificar si ya existe la arista
        if (existeArista(destino.getNombre())) {
            return false;
        }
        
        // Agregar nueva arista
        adyacentes.add(new Arista(destino.getNombre(), peso));
        return true;
    }

    @Override
    public boolean existeArista(String nombreDestino) {
        if (nombreDestino == null || nombreDestino.isEmpty()) return false;
        
        for (IArista arista : adyacentes) {
            if (arista.getDestino().equals(nombreDestino)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<IArista> getAdyacentes() {
        return new ArrayList<>(adyacentes);
    }

    @Override
    public double getPesoA(String nombreDestino) {
        for (IArista arista : adyacentes) {
            if (arista.getDestino().equals(nombreDestino)) {
                return arista.getPeso();
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) return false;
        Vertice v = (Vertice) otro;
        return nombre.equalsIgnoreCase(v.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Estación: " + nombre;
    }
}