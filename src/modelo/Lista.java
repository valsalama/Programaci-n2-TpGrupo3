package modelo;

import interfaz.ILista;
import interfaz.INodo;
import interfaz.IVehiculo;

public class Lista implements ILista {

    private INodo primero;

    // Constructor
    public Lista() {
        this.primero = null;
    }

    // Verifica si la lista está vacía
    @Override
    public boolean esVacia() {
        return primero == null;
    }

    // Inserta un nuevo nodo al principio de la lista
    @Override
    public void insertarPrimero(IVehiculo dato) {
        Nodo nuevo = new Nodo(dato);
        if (!esVacia()) {
            primero.setAnterior(nuevo);
            nuevo.setSiguiente(primero);
        }
        primero = nuevo;
    }

    // Inserta un nuevo nodo al final de la lista
    @Override
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

    // Retorna el dato del primer nodo
    @Override
    public IVehiculo obtenerPrimero() {
        if (esVacia())
            throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }

    // Retorna la cantidad total de elementos en la lista
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

    // Muestra todos los elementos de la lista por consola
    @Override
    public void mostrar() {
        INodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato() + "\n");
            actual = actual.getSiguiente();
        }
    }

    // Inserta un nuevo nodo en una posición específica
    @Override
    public void insertarGenerico(IVehiculo dato, int pos) {
        Nodo nuevo = new Nodo(dato);
        if (!esVacia()) {
            if (pos == 0) {
                insertarPrimero(dato);
                return;
            }

            int contador = 0;
            INodo actual = primero;
            while (contador < pos && actual.getSiguiente() != null) {
                contador++;
                actual = actual.getSiguiente();
            }

            if (actual.getSiguiente() == null) {
                insertarUltimo(dato);
            } else {
                nuevo.setAnterior(actual.getAnterior());
                nuevo.setSiguiente(actual);
                actual.getAnterior().setSiguiente(nuevo);
                actual.setAnterior(nuevo);
            }
        } else {
            System.out.println("Error: La lista esta vacia");
        }
    }

    // Elimina y retorna el primer nodo de la lista
    @Override
    public IVehiculo eliminarPrimero() {
        if (!esVacia()) {
            IVehiculo datoEliminado = primero.getDato();
            primero = primero.getSiguiente();
            return datoEliminado;
        } else {
            System.out.println("Error: Lista vacia.");
            return null;
        }
    }

    // Elimina y retorna el último nodo de la lista
    @Override
    public IVehiculo eliminarUltimo() {
        if (esVacia()) {
            return null;
        } else {
            INodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            IVehiculo v = actual.getDato();
            if (actual == primero) {
                primero = null;
            } else {
                actual.getAnterior().setSiguiente(null);
            }
            return v;
        }
    }

    // Elimina un nodo en una posición específica
    @Override
    public IVehiculo eliminarGenerico(int pos) {
        if (!esVacia() && pos < cantidadElementos()) {
            int contador = 0;
            INodo actual = primero;

            while (contador != pos && actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
                contador++;
            }

            INodo anteriorEliminado = actual.getAnterior();
            INodo siguienteEliminado = actual.getSiguiente();

            if (anteriorEliminado != null)
                anteriorEliminado.setSiguiente(siguienteEliminado);
            if (siguienteEliminado != null)
                siguienteEliminado.setAnterior(anteriorEliminado);

            return actual.getDato();
        } else {
            System.out.println("Error: La lista esta vacia o la posicion esta fuera de rango.");
            return null;
        }
    }

    // Retorna el dato del último nodo
    @Override
    public IVehiculo obtenerUltimo() {
        if (esVacia()) {
            throw new IllegalStateException("Lista vacía");
        }
        INodo actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    // Retorna el dato en una posición específica
    @Override
    public IVehiculo obtenerGenerico(int pos) {
        if (!esVacia() && pos < cantidadElementos()) {
            int contador = 0;
            INodo actual = primero;

            while (contador != pos && actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
                contador++;
            }

            return actual.getDato();
        } else {
            System.out.println("Error: La lista esta vacia");
            return null;
        }
    }

    // Ordena la lista usando el método de burbujeo por patente
    @Override
    public void ordenar() {
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

                if (comparacionPatente > 0) {
                    IVehiculo temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    intercambiado = true;
                }

                actual = actual.getSiguiente();
            }

        } while (intercambiado);
    }

    // Busca un vehículo en la lista y devuelve su posición
    @Override
    public int buscar(IVehiculo a) {
        if (!esVacia()) {
            int contador = 0;
            INodo actual = primero;

            while (actual.getDato() != a && actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
                contador++;
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

    // Representación en String de la lista
    @Override
    public String toString() {
        return "Lista [ primero= " + primero + " ]";
    }
}