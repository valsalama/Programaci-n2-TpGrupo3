package modelo;

import interfaz.IVehiculo;

public class Vehiculo implements IVehiculo {

    private String modelo;
    private String patente;

    // Constructor
    public Vehiculo(String modelo, String patente) {
        super();
        this.modelo = modelo;
        this.patente = patente;
    }

    // Getter y Setters
    // Modelo
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Patente
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    // String
    @Override
    public String toString() {
        return "Vehiculo [ modelo= " + modelo + ", patente= " + patente + " ]";
    }
}
