package modelo;

import java.util.*;
import interfaz.IGrafo;

public class Grafo implements IGrafo {

    private Map<String, Nodo> vertices; // Todas las estaciones
    private Map<String, List<Arista>> adyacencias; // Conexiones entre estaciones

    public Grafo() {
        vertices = new HashMap<>();
        adyacencias = new HashMap<>();
    }

    @Override
    public void agregarVertice(Vertice vertice) {
        String nombre = vertice.getNombre();
        if (!vertices.containsKey(nombre)) {
            vertices.put(nombre, new Nodo(nombre));
            adyacencias.put(nombre, new ArrayList<>());
        }
    }

    @Override
    public void agregarArista(String origen, String destino, double peso) {
        if (!vertices.containsKey(origen) || !vertices.containsKey(destino)) {
            throw new IllegalArgumentException("Ambas estaciones deben existir en el sistema.");
        }
        
        // Conexión bidireccional (se puede ir en ambas direcciones)
        adyacencias.get(origen).add(new Arista(destino, peso));
        adyacencias.get(destino).add(new Arista(origen, peso));
    }

    @Override
    public boolean existeVertice(String vertice) {
        return vertices.containsKey(vertice);
    }

    @Override
    public double getPesoArista(String origen, String destino) {
        if (!adyacencias.containsKey(origen)) return -1;
        
        for (Arista a : adyacencias.get(origen)) {
            if (a.getDestino().equals(destino)) {
                return a.getPeso();
            }
        }
        return -1;
    }

    @Override
    public List<String> dijkstra(String origen, String destino) {
        // Verificar que ambas estaciones existen
        if (!vertices.containsKey(origen) || !vertices.containsKey(destino)) {
            return null;
        }

        // Inicializar estructuras para Dijkstra
        Map<String, Double> distancias = new HashMap<>(); // Distancia mínima a cada estación
        Map<String, String> anteriores = new HashMap<>(); // Estación anterior en la ruta óptima
        PriorityQueue<NodoDistancia> cola = new PriorityQueue<>(
            Comparator.comparingDouble(nd -> nd.distancia)
        );

        // Inicializar todas las distancias como infinito
        for (String estacion : vertices.keySet()) {
            distancias.put(estacion, Double.MAX_VALUE);
            anteriores.put(estacion, null);
        }
        
        // La distancia al origen es 0
        distancias.put(origen, 0.0);
        cola.add(new NodoDistancia(origen, 0.0));

        // Algoritmo de Dijkstra
        while (!cola.isEmpty()) {
            NodoDistancia actual = cola.poll();
            String estacionActual = actual.nodo;

            // Si llegamos al destino, terminamos
            if (estacionActual.equals(destino)) break;

            // Revisar todas las estaciones conectadas
            for (Arista conexion : adyacencias.get(estacionActual)) {
                String estacionVecina = conexion.getDestino();
                double nuevaDistancia = distancias.get(estacionActual) + conexion.getPeso();
                
                // Si encontramos una ruta más corta, la actualizamos
                if (nuevaDistancia < distancias.get(estacionVecina)) {
                    distancias.put(estacionVecina, nuevaDistancia);
                    anteriores.put(estacionVecina, estacionActual);
                    cola.add(new NodoDistancia(estacionVecina, nuevaDistancia));
                }
            }
        }

        // Si no hay ruta al destino
        if (distancias.get(destino) == Double.MAX_VALUE) {
            return null;
        }

        // Reconstruir la ruta desde el destino hacia el origen
        LinkedList<String> ruta = new LinkedList<>();
        for (String estacion = destino; estacion != null; estacion = anteriores.get(estacion)) {
            ruta.addFirst(estacion);
        }
        
        return ruta;
    }

    private static class NodoDistancia {
        String nodo;
        double distancia;

        public NodoDistancia(String nodo, double distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }
    }
}
