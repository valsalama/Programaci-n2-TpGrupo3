package interfaz;

public interface INodo<T extends IPersona> {
	
	public T getDato();
	public void setDato(T dato);
	public INodo<T> getIzquierda();
	public void setIzquierda(INodo<T> izquierda);
	public INodo<T> getDerecha();
	public void setDerecha(INodo<T> derecha);
	public String toString();
}
