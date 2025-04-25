package modelo;

import interfaz.ILista;
import interfaz.INodo;
import interfaz.IVehiculo;

//Saque la implementación implements ILista, OJO ustedes la mantienen	
public class Lista implements ILista {
	
    private INodo primero;

    public Lista() {
        this.primero = null;
    }
    public boolean esVacia() {
        return primero == null;
    }
    
    public void insertarPrimero(IVehiculo dato) {
        Nodo nuevo = new Nodo(dato);
    	if(!esVacia()) {
    	primero.setAnterior(nuevo);
        nuevo.setSiguiente(primero);
        primero = nuevo;
    	}else {
    		primero = nuevo;
    	}
    }

    public void insertarUltimo(IVehiculo dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = nuevo;
        } else {
            INodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setAnterior(actual);
        }
    }

    public IVehiculo obtenerPrimero() {
        if (esVacia()) throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }

    public int cantidadElementos() {
        int contador = 0;
        INodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public void mostrar() {
        INodo actual = primero;
        while (actual != null) {
        	//getDato --- Del Nodo ---- Vehiculo!!!
            System.out.print(actual.getDato() +"\n");
            actual = actual.getSiguiente();
        }
    }

	@Override
	public void insertarGenerico(IVehiculo dato, int pos) {
		Nodo nuevo = new Nodo(dato);
		if (!esVacia()) {
			if (pos == 0) {
				insertarPrimero(dato);
			}
			int contador = 0;
			INodo actual = primero;
			while (contador < pos && actual.getSiguiente() != null) {
				contador ++;
				actual = actual.getSiguiente();
			}
			if (actual.getSiguiente() == null) {
				insertarUltimo(dato);
			}
			else {
				nuevo.setAnterior(actual.getAnterior());
				nuevo.setSiguiente(actual);
				actual.getAnterior().setSiguiente(nuevo);
				actual.setAnterior(nuevo);
			}
		}
		else {
			System.out.println("Error: La lista esta vacia");
		}
		
	}

	@Override
	public IVehiculo eliminarPrimero() {
		if (!esVacia()) {
			IVehiculo datoEliminado = primero.getDato();
			//destructor(primero); //java los resuelve solos no hay que hacerlos
			primero = primero.getSiguiente();
			
			return datoEliminado;
		}
		else {
			System.out.println("Error: Lista vacia.");
			return null;
		}
	}

	@Override
	public IVehiculo eliminarUltimo() {
		if (esVacia()) {
			return null;
		}
		else {
			INodo actual = primero;
			while(actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
			}
			IVehiculo v = actual.getDato();
			if (actual == primero) {
				actual = null;
				primero = null;
			}
			else {
			(actual.getAnterior()).setSiguiente(null);
			}
			return v;
		}
	}
	
	@Override
	public IVehiculo eliminarGenerico(int pos) {
		if (!esVacia() && pos < cantidadElementos()) {
			int contador = 0;
			INodo actual = primero;
			while (contador != pos && actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
				contador ++;
			}
			INodo anteriorEliminado = actual.getAnterior();
			INodo siguienteEliminado = actual.getSiguiente();
			actual.getAnterior().setSiguiente(siguienteEliminado);
			actual.getSiguiente().setAnterior(anteriorEliminado);
			return actual.getDato();
		}
		else {
			System.out.println("Error: La lista esta vacia o la posicion esta fuera de rango.");
			return null;
		}
	}
	
	@Override
	public int obtenerUltimo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IVehiculo obtenerGenerico(int pos) {
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

	@Override
	public void ordenar() {//metodo burbujeo
	    if (esVacia() || primero.getSiguiente() == null) {
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
	                IVehiculo temp = actual.getDato();
	                actual.setDato(siguiente.getDato());
	                siguiente.setDato(temp);
	                intercambiado = true;
	            }
	            actual = actual.getSiguiente();
	        }
	    } while (intercambiado); // repite el proceso si hay intercambios
	}

	@Override
	public int buscar(IVehiculo a) {
		if (!esVacia()) {
			int contador = 0;
			INodo actual = primero;
			while (actual.getDato() != a && actual.getSiguiente() != null) {
				actual = actual.getSiguiente();
				contador ++;
			}
			if (actual.getDato() == a) {
				return contador;
			}
			else {
				System.out.println("Error: El valor ingresado no se encontró.");
				return -1;
			}
		}
		else {
			System.out.println("Error: La lista esta vacia.");
			return -1;
		}
	}

	@Override
	public INodo getPrimero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPrimero(INodo primero) {
		// TODO Auto-generated method stub
	}
	@Override
	public String toString() {
		return "Lista [primero=" + primero + "]";
	}
	
}
