package interfaz;

public interface IArbol<T extends IPersona> {
	
	public INodo<T> getRaiz();
	public void setRaiz(INodo<T> raiz);
	public String toString();
	public void insertar(T dato);
	public INodo<T> insertarRecursivo(INodo<T> nodoRaiz, T dato);
	public void eliminar(T dato);
	public INodo<T> eliminarRecursivo(INodo<T> nodoRaiz, T dato);
	public INodo<T> encontrarMinimo(INodo<T> n);
	public INodo<T> buscar(T dato);
	public INodo<T> buscarRecursivo(INodo<T> nodo, T dato);
	public void recorridoInorden();
	public void inordenRecursivo(INodo<T> nodo);
	public void recorridoPreorden();
	public void preordenRecursivo(INodo<T> nodo);
	public void recorridoPostorden();
	public void postordenRecursivo(INodo<T> nodo);
}
