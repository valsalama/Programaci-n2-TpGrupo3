package interfaces;

public interface IArista {

	String getDestino();
	/**
	 * Pre: El objeto arista esta correctamente inicializado.
	 * Post: Se retorna el nombre del vertice destino asociado a esta arista.
	 * Axioma: El valor devuelto corresponde al nombre almacenado internamente.
	 */

	double getPeso();
	/**
	 * Pre: El objeto arista esta correctamente inicializado.
	 * Post: Se retorna el valor numerico asociado como peso a la arista.
	 * Axioma: El peso es un numero real mayor o igual a cero.
	 */

	void setPeso(double peso);
	/**
	 * Pre: El objeto arista esta correctamente inicializado.
	 * Post: El peso de la arista queda actualizado con el nuevo valor recibido.
	 * Axioma: getPeso() posterior a la llamada devuelve el valor establecido.
	 */

	boolean equals(Object obj);
	/**
	 * Pre: El objeto pasado como parametro puede ser null o no ser una arista.
	 * Post: Devuelve true si el objeto es una arista y tiene igual destino y peso.
	 * Axioma: La comparacion es reflexiva, simetrica y transitiva.
	 */

	int hashCode();
	/**
	 * Pre: El objeto arista esta correctamente inicializado.
	 * Post: Se devuelve un codigo hash consistente con equals().
	 * Axioma: Si dos aristas son iguales segun equals(), tienen el mismo hashCode().
	 */

}

