package modelo;

import java.util.Objects;
import interfaz.IArista;

public class Arista implements IArista {

    private String destino;
    private double peso; // Distancia en kilómetros

    public Arista(String destino, double peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public String getDestino() {
        return destino;
    }

    @Override
    public double getPeso() {
        return peso;
    }

    @Override
    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Arista)) return false;
        Arista otra = (Arista) obj;
        return Objects.equals(this.destino, otra.destino) && 
               Double.compare(this.peso, otra.peso) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(destino, peso);
    }

    @Override
    public String toString() {
        return "→ " + destino + " [" + peso + " km]";
    }
}
