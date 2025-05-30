package Modelo;

public class Arbol {
	
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
		while (n != null) {
			n = n.getIzquierda();
		}
		return n;
	}
	@Override
    public INodo buscar(Persona dato) {
        return buscarRec(nodoRaiz, dato);
    }
    private INodo buscarRec(INodo nodo, int dato) {
        if (nodoRaiz == null || nodoRaiz.getDato() == dato) { //|| OR
            return nodoRaiz;
        }
        if (dato < nodoRaiz.getDato()) {
            return buscarRec(nodoRaiz.getIzquierdo(), dato);
        } else {
            return buscarRec(nodoRaiz.getDerecho(), dato);
        }
    }
	 @Override
    public void recorridoInorden() {
        inordenRec(raiz);
    }
    private void inordenRec(INodo nodo) {
        if (nodoRaiz != null) {
            inordenRec(nodoRaiz.getIzquierda());
            System.out.print(nodoRaiz.getDato() + " ");
            inordenRec(nodoRaiz.getDerecho());
        }
    }
    @Override
    public void recorridoPreorden() {
        preordenRec(raiz);
    }
    private void preordenRec(INodo nodo) {
        if (nodo != null) {
            System.out.print(nodoRaiz.getDato() + " ");
            preordenRec(nodoRaiz.getIzquierda()); 
            preordenRec(nodoRaiz.getDerecho());
        }
    }
    @Override
    public void recorridoPostorden() {
        postordenRec(raiz);
    }
    private void postordenRec(INodo nodo) {
        if (nodoRaiz != null) {
            postordenRec(nodoRaiz.getIzquierda());
            postordenRec(nodoRaiz.getDerecho());
            System.out.print(nodoRaiz.getDato() + " ");
        }
    }
}
