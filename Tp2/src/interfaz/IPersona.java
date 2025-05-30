package Interfaz;

public interface IPersona extends Comparable<IPersona> {
	
	public int getDni();
	public void setDni(int dni);
	public String getNombre();
	public void setNombre(String nombre);
	public String toString();
	public int compareTo(IPersona p);
}
