package interfaz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public interface IGrafo<T extends IPersona> {
	
	public void agregarNodo(T valor);
	public void agregarArista(T origen, T destino, int peso);
	public void mostrarListaAdyacencia();
	public void mostrarMatrizAdyacencia();
	public void bfs(T inicio);
    public void dfs(T inicio);
    private void dfsRecursivo(INodo<T> actual, Set<T> visitados);
}
