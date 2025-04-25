package interfaz;


public interface INodo {
	
	public INodo getAnterior();
	public void setAnterior(INodo anterior);
    public IVehiculo getDato();
    public void setDato(IVehiculo dato);
    public INodo getSiguiente();
    public void setSiguiente(INodo nodo);
    public String toString();
}
