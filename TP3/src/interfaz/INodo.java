package interfaz;

import java.util.List;

public interface INodo<T> {
	
	public T getDato();
	public List<INodo<T>> getVecinos();
	public List<Integer> getPesos();
	public String toString();
	public void agregarVecino(INodo<T> vecino, int peso);
}
