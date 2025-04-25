package interfaz;

public interface IPersona {
	
	// Nombre
	public String getNombre();
	public void setNombre(String nombre);

	// DNI
	public int getDni();
	public void setDni(int dni);

	// Lista de Vehiculos
	public ILista getListaVehiculos();
	public void setListaVehiculos(ILista listaVehiculos);

	// Mostrar Persona
	public void mostrarPersona();
}