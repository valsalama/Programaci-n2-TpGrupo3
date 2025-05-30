package model;

import interfaz.IArbol;

public class Arbol implements IArbol {
	
	private Nodo raiz;

	public Nodo getRaiz() {
		return raiz;
	}
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	@Override
	public String toString() {
		return "Arbol [raiz=" + raiz + "]";
	}
	public Arbol(Nodo raiz) {
		super();
		this.raiz = null;
	}
	
	public void insertar(Persona dato) {
		raiz = insertarRecursivo(raiz, dato);
	}
	
	public Nodo insertarRecursivo(Nodo nodoRaiz, Persona dato) {
		if (nodoRaiz == null) {
			return new Nodo(dato);
		}
		int comparar = dato.getNombre().compareTo(nodoRaiz.getDato().getNombre());
		if (comparar < 0){
			nodoRaiz.setIzquierda(insertarRecursivo(nodoRaiz.getIzquierda(), dato));
		}
		else if (comparar > 0){
			nodoRaiz.setDerecha(insertarRecursivo(nodoRaiz.getDerecha(), dato));
		}
		return nodoRaiz;
	}
	
	public void eliminar(Persona dato) {
		raiz = eliminarRecursivo(raiz, dato);
	}
	
	public Nodo eliminarRecursivo(Nodo nodoRaiz, Persona dato) {
		if (nodoRaiz == null) {
			return new Nodo(dato);
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
            Nodo sucesor = encontrarMinimo(nodoRaiz.getDerecha());
            nodoRaiz.setDato(sucesor.getDato());
            nodoRaiz.setDerecha(eliminarRecursivo(nodoRaiz.getDerecha(), sucesor.getDato()));
		}
		return nodoRaiz;
	}
	
	public Nodo encontrarMinimo(Nodo n) {
        if (n == null) return null;
        while (n.getIzquierda() != null) {
            n = n.getIzquierda();
        }
        return n;
    }
	
	public Nodo buscar(Persona dato) {
        return buscarRec(raiz, dato);
    }
	
	private Nodo buscarRec(Nodo nodo, Persona dato) {
        if (nodo == null || nodo.getDato().compareTo(dato) == 0) {
            return nodo;
        }
        if (dato.compareTo(nodo.getDato()) < 0) {
            return buscarRec(nodo.getIzquierda(), dato);
        } else {
            return buscarRec(nodo.getDerecha(), dato);
        }
    }
	
	public void recorridoInorden() {
        inordenRec(raiz);
    }
	
	private void inordenRec(Nodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.getIzquierda());
            System.out.print(nodo.getDato() + " ");
            inordenRec(nodo.getDerecha());
        }
    }
	
	public void recorridoPreorden() {
        preordenRec(raiz);
    }
	
	private void preordenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preordenRec(nodo.getIzquierda());
            preordenRec(nodo.getDerecha());
        }
    }
	
	public void recorridoPostorden() {
        postordenRec(raiz);
    }
	
	private void postordenRec(Nodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.getIzquierda());
            postordenRec(nodo.getDerecha());
            System.out.print(nodo.getDato() + " ");
        }
    }
}