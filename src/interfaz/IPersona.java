package interfaz;

public interface IPersona {
	
	public int getDni();
	public void setDni(int dni);
	public String getNombre();
	public void setNombre(String nombre);
	public ILista getListaVehiculos();
	public void setListaVehiculos(ILista listaVehiculos);
	public void mostrarPersona();
}
