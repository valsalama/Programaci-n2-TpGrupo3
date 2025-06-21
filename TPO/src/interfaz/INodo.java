package interfaz;

public interface INodo {

    // Obtiene el nombre del nodo
    String getNombre();
    
    // Establece el nombre del nodo
    void setNombre(String nombre);
    
    // Compara si dos nodos son iguales por su nombre
    boolean equals(Object otro);
    
    // Genera código hash basado en el nombre
    int hashCode();
}
