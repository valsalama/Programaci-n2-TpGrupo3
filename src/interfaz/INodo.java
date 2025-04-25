package interfaz;


public interface INodo {
	
    // Dato
    public IVehiculo getDato();
    public void setDato(IVehiculo dato);
    
    // Anterior
	public INodo getAnterior();
	public void setAnterior(INodo anterior);

    // Siguiente
    public INodo getSiguiente();
    public void setSiguiente(INodo nodo);
}
