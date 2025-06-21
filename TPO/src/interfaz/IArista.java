package interfaz;

public interface IArista {

    // Obtiene el nombre de la estación destino
    String getDestino();

    // Obtiene la distancia en km entre estaciones
    double getPeso();

    // Establece la distancia entre estaciones
    void setPeso(double peso);
    
    // Compara si dos aristas son iguales
    boolean equals(Object obj);
    
    // Genera código hash para la arista
    int hashCode();
}
