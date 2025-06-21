package interfaz;

public interface INodo {

    String getNombre();
    /**
     * Pre: El nodo esta correctamente inicializado.
     * Post: Se retorna el nombre asignado al nodo.
     * Axioma: El valor devuelto corresponde al identificador unico del nodo.
     */

    void setNombre(String nombre);
    /**
     * Pre: El parametro nombre no es null ni vacio.
     * Post: El nombre del nodo queda actualizado con el valor recibido.
     * Axioma: getNombre() devuelve el nuevo nombre despues de la llamada.
     */

    boolean equals(Object otro);
    /**
     * Pre: El objeto pasado puede ser null o no ser un nodo.
     * Post: Devuelve true si el objeto es un nodo y tiene igual nombre.
     * Axioma: La comparacion es reflexiva, simetrica y transitiva.
     */

    int hashCode();
    /**
     * Pre: El nodo esta correctamente inicializado.
     * Post: Devuelve un codigo hash consistente con equals().
     * Axioma: Si dos nodos son iguales segun equals(), tienen el mismo hashCode().
     */
}
