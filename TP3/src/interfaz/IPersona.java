package interfaz;

public interface IPersona extends Comparable<IPersona> {
	
	public String getNombre();
	public void setNombre(String nombre);
	public int getDni();
	public void setDni(int dni);
	public String toString();
}
