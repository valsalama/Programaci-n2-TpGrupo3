package model;

import interfaz.IArbol;
import interfaz.INodo;
import interfaz.IPersona;

public class Arbol<T extends IPersona> implements IArbol<T> {
	
	private INodo<T> raiz;

	public INodo<T> getRaiz() {
		return raiz;
	}
	public void setRaiz(INodo<T> raiz) {
		this.raiz = raiz;
	}
	@Override
	public String toString() {
		return "Arbol [raiz=" + raiz + "]";
	}
	public Arbol() {
		super();
		this.raiz = null;
	}
	
	public void insertar(T dato) {
		raiz = insertarRecursivo(raiz, dato);
	}
	
	public INodo<T> insertarRecursivo(INodo<T> nodoRaiz, T dato) {
		if (nodoRaiz == null) {
			return new Nodo<T>(dato);
		}
		int comparar = dato.getNombre().compareTo(nodoRaiz.getDato().getNombre());
		if (comparar < 0){
			nodoRaiz.setIzquierda(insertarRecursivo(nodoRaiz.getIzquierda(), dato));
		}
		else if (comparar > 0){
			nodoRaiz.setDerecha(insertarRecursivo(nodoRaiz.getDerecha(), dato));
		}
		else {
			return null; // si se encuentra dni y nombre igual, no se inserta
		}
		return nodoRaiz;
	}
	
	public void eliminar(T dato) {
		raiz = eliminarRecursivo(raiz, dato);
	}
	
	public INodo<T> eliminarRecursivo(INodo<T> nodoRaiz, T dato) {
		if (nodoRaiz == null) {
			return new Nodo<T>(dato);
		}
		int comparar = dato.getNombre().compareTo(nodoRaiz.getDato().getNombre());
		if (comparar < 0){
			nodoRaiz.setIzquierda(eliminarRecursivo(nodoRaiz.getIzquierda(), dato));
		}
		else if (comparar > 0){
			nodoRaiz.setDerecha(eliminarRecursivo(nodoRaiz.getDerecha(), dato));
		}
		else {
			if (nodoRaiz.getIzquierda() == null && nodoRaiz.getDerecha() == null) {
                return null;
            }
            if (nodoRaiz.getIzquierda() == null) {
                return nodoRaiz.getDerecha();
            }
            if (nodoRaiz.getDerecha() == null) {
                return nodoRaiz.getIzquierda();
            }
            INodo<T> sucesor = encontrarMinimo(nodoRaiz.getDerecha());
            nodoRaiz.setDato(sucesor.getDato());
            nodoRaiz.setDerecha(eliminarRecursivo(nodoRaiz.getDerecha(), sucesor.getDato()));
		}
		return nodoRaiz;
	}

	public INodo<T> encontrarMinimo(INodo<T> n) {
		while (n != null) {
			n = n.getIzquierda();
		}
		return n;
	}
	public INodo<T> buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }
	
	public INodo<T> buscarRecursivo(INodo<T> nodo, T dato) {
        if (nodo == null || nodo.getDato().compareTo(dato) == 0) {
            return nodo;
        }
        if (dato.compareTo(nodo.getDato()) < 0) {
            return buscarRecursivo(nodo.getIzquierda(), dato);
        } else {
            return buscarRecursivo(nodo.getDerecha(), dato);
        }
    }
	
	public void recorridoInorden() {
        inordenRecursivo(raiz);
    }
	
	public void inordenRecursivo(INodo<T> nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.getIzquierda());
            System.out.print(nodo.getDato() + " ");
            inordenRecursivo(nodo.getDerecha());
        }
    }
	
	public void recorridoPreorden() {
        preordenRecursivo(raiz);
    }
	
	public void preordenRecursivo(INodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preordenRecursivo(nodo.getIzquierda());
            preordenRecursivo(nodo.getDerecha());
        }
    }
	
	public void recorridoPostorden() {
        postordenRecursivo(raiz);
    }
	
	public void postordenRecursivo(INodo<T> nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.getIzquierda());
            postordenRecursivo(nodo.getDerecha());
            System.out.print(nodo.getDato() + " ");
        }
    }
}
