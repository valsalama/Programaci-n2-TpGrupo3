package interfaz;

import java.util.List;
import modelo.Vertice;

public interface IGrafo {

    // Agrega una nueva estación al sistema
    void agregarVertice(Vertice vertice);
    
    // Conecta dos estaciones con una distancia específica
    void agregarArista(String origen, String destino, double peso);
    
    // Verifica si una estación existe en el sistema
    boolean existeVertice(String vertice);
    
    // Obtiene la distancia directa entre dos estaciones conectadas
    double getPesoArista(String origen, String destino);
    
    // Encuentra la ruta más corta entre dos estaciones usando Dijkstra
    List<String> dijkstra(String origen, String destino);
}
