package interfaz;

import java.util.List;

public interface IVertice {

    String getNombre();
    /**
     * Pre: El vertice esta correctamente inicializado.
     * Post: Se retorna el nombre unico asignado al vertice.
     * Axioma: El valor devuelto es el identificador unico del vertice.
     */

    void setNombre(String nombre);
    /**
     * Pre: El parametro nombre no es null ni vacio.
     * Post: El nombre del nodo queda actualizado con el valor recibido.
     * Axioma: getNombre() devuelve el nuevo nombre despues de la llamada.
     */

    boolean agregarArista(IVertice destino, double peso);
    /**
     * Pre: El vertice destino no debe ser null.
     * Post: Se agrega una arista del vertice actual hacia el destino con el peso indicado.
     *       Si la arista ya existia, no se modifica y retorna false.
     * Axioma: El conjunto de adyacencias se actualiza con la nueva arista en caso exitoso.
     */

    boolean existeArista(String nombreDestino);
    /**
     * Pre: El nombreDestino no es null ni vacio.
     * Post: Retorna true si el vertice actual tiene una arista hacia el vertice con ese nombre.
     * Axioma: La respuesta refleja la existencia real en la lista de adyacencias.
     */

    List<IArista> getAdyacentes();
    /**
     * Pre: El vertice esta correctamente inicializado.
     * Post: Retorna la lista de aristas salientes desde este vertice.
     * Axioma: La lista refleja el estado actual de las conexiones del vertice.
     */

    double getPesoA(String nombreDestino);
    /**
     * Pre: El vertice destino existe en las adyacencias del vertice actual.
     * Post: Retorna el peso asociado a la arista hacia ese vertice.
     *       Si no existe, retorna -1.
     * Axioma: El valor devuelto es consistente con la informacion almacenada.
     */
}
