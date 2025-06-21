package interfaz;

public interface IGrafoGenerico<T> {
	
	public void agregarNodo(T valor);
	public void agregarArista(T origen, T destino, int peso);
	public void mostrarListaAdyacencia();
	public void mostrarMatrizAdyacencia();
	public void bfs(T inicio);
    public void dfs(T inicio);
    public void setDirigido(boolean dirigido);
    public boolean esDirigido();
}