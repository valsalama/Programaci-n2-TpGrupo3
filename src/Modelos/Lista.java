package Modelos;

import Interfaces.ILista;
import Interfaces.INodo;

public class Lista implements ILista {
	
    private INodo primero;
    private INodo ultimo;

    // Constructor
    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    // Verificar si esta vacio
    @Override
    public boolean esVacia() {
        return primero == null;
    }
    
    // Insertar elemento al principioß
    @Override
    public void insertarPrimero(Vehiculo dato) {
        Nodo nuevo = new Nodo(dato);
    	if(!esVacia()) {
            primero.setAnterior(nuevo);
            nuevo.setSiguiente(primero);
            primero = nuevo;
    	}else {
    		primero = nuevo;
    		ultimo = nuevo;
    	}
    }

    // Insertar elemento al final
    @Override
    public void insertarUltimo(Vehiculo dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo=nuevo;
        }
    }

    @Override
    public Vehiculo obtenerPrimero() {
        if (esVacia()) throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }

    @Override
    public int cantidadElementos() {
        int contador = 0;
        INodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public void mostrar() {
        INodo actual = primero;
        while (actual != null) {
        	//getDato --- Del Nodo ---- Vehiculo!!!
            System.out.print(actual.getDato() +"\n");
            actual = actual.getSiguiente();
        }
    }

    @Override
    public void insertarGenerico(Vehiculo dato, int pos) {
        if (pos < 0 || pos > cantidadElementos()) {
            System.out.println("Error: Posicion fuera de rango");
            return;
        }
        Nodo nuevoNodo = new Nodo(dato); 
        if (pos == 0) {
            insertarPrimero(dato); 
            return;
        }
        INodo actual = primero;
        int contador = 0;
        while (contador < pos - 1) {
            actual = actual.getSiguiente();
            contador++;
        }
        INodo siguienteNodo = actual.getSiguiente();
        actual.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(actual);
        if (siguienteNodo != null) {
            nuevoNodo.setSiguiente(siguienteNodo);
            siguienteNodo.setAnterior(nuevoNodo);
        }
    }

	@Override
	public Vehiculo eliminarPrimero() {
		if (!esVacia()) {
            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            }
			return primero.getDato();
		} else {
			System.out.println("Error: Lista vacia.");
			return null;
		}
	}

	@Override
	public Vehiculo eliminarUltimo() {
		if (esVacia()) {
			return null;
		}
		else {
			INodo actual = primero;
			while(actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			INodo anteultimo = actual.getAnterior();
			anteultimo.setSiguiente(null);
			return actual.getDato();
		}
	}
	
	@Override
	public Vehiculo eliminarGenerico(int pos) {
		if (!esVacia() && pos < cantidadElementos()) {
			int contador = 0;
			INodo actual = primero;
			while (contador != pos && actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
				contador ++;
			}
			INodo anteriorEliminado = actual.getAnterior();
			INodo siguienteEliminado = actual.getSiguiente();
			anteriorEliminado.setSiguiente(siguienteEliminado);
			siguienteEliminado.setAnterior(anteriorEliminado);
			return actual.getDato();
		}
		else {
			System.out.println("Error: La lista esta vacia");
			return null;
		}
	}
	
	@Override
	public Vehiculo obtenerUltimo() {
	    if (esVacia()) {
	        System.out.println("Error: La lista esta vacia");
	        return null;  
	    }
	    
	    INodo actual = primero;
	    while (actual.getSiguiente() != null) {
	        actual = actual.getSiguiente();
	    }
	    return actual.getDato();
	}

	@Override
	public Vehiculo obtenerGenerico(int pos) {
		if (!esVacia() && pos < cantidadElementos()) {
			int contador = 0;
			INodo actual = primero;
			while (contador != pos && actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
				contador ++;
			}
			return actual.getDato();
		}
		else {
			System.out.println("Error: La lista esta vacia");
			return null;
		}
	}

    // Ordenar la lista por patente
	@Override
	public void ordenar() {
	    if (esVacia() && primero.getSiguiente() == null) {
	        return;
	    }
	    boolean intercambiado;
	    do {
	        intercambiado = false;
	        INodo actual = primero;
	        while (actual.getSiguiente() != null) {
	            INodo siguiente = actual.getSiguiente();
	            int comparacionPatente = actual.getDato().getPatente().compareTo(siguiente.getDato().getPatente());
	            // si la patente actual es mayor que la siguiente los intercambia
	            if (comparacionPatente > 0) {
	                Vehiculo temp = actual.getDato();
	                actual.setDato(siguiente.getDato());
	                siguiente.setDato(temp);
	                intercambiado = true;
	            }
	            actual = actual.getSiguiente();
	        }
	    } while (intercambiado); // repite el proceso si hay intercambios
	}

    // Buscar un vehiculo en la lista
	@Override
	public int buscar(Vehiculo a) {
		if (!esVacia()) {
			int contador = 0;
			INodo actual = primero;
			while (actual.getDato() != a && actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
				contador ++;
			}
			if (actual.getDato() == a) {
				return contador;
			} else {
				System.out.println("Error: El valor ingresado no se encontró.");
				return -1;
			}
		} else {
			System.out.println("Error: La lista esta vacia.");
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Lista [ primero=" + primero + " , ultimo=" + ultimo + " ]";
	}
	
}