package interfaz;

import model.Persona;
import model.Nodo;

public interface IArbol {
	
	public Nodo getRaiz();
	public void setRaiz(Nodo raiz);
	public String toString();
	public void insertar(Persona dato);
	public void eliminar(Persona dato);
	public Nodo buscar(Persona dato);
	public Nodo encontrarMinimo(Nodo n);
	public void recorridoInorden();
	public void recorridoPreorden();
	public void recorridoPostorden();
}
