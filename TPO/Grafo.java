package modelo;

import java.util.*;

import interfaces.IGrafo;


public class Grafo implements IGrafo {

    private Map<String, Nodo> vertices;
    private Map<String, List<Arista>> adyacencias;

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
            throw new IllegalArgumentException("Ambos vertices deben existir.");
        }
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
        if (!vertices.containsKey(origen) || !vertices.containsKey(destino)) {
            return null;
        }

        Map<String, Double> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<NodoDistancia> pq = new PriorityQueue<>(Comparator.comparingDouble(nd -> nd.distancia));

        for (String v : vertices.keySet()) {
            dist.put(v, Double.MAX_VALUE);
            prev.put(v, null);
        }
        dist.put(origen, 0.0);
        pq.add(new NodoDistancia(origen, 0.0));

        while (!pq.isEmpty()) {
            NodoDistancia actual = pq.poll();
            String u = actual.nodo;

            if (u.equals(destino)) break;

            for (Arista arista : adyacencias.get(u)) {
                String v = arista.getDestino();
                double alt = dist.get(u) + arista.getPeso();
                if (alt < dist.get(v)) {
                    dist.put(v, alt);
                    prev.put(v, u);
                    pq.add(new NodoDistancia(v, alt));
                }
            }
        }

        if (dist.get(destino) == Double.MAX_VALUE) return null;

        LinkedList<String> ruta = new LinkedList<>();
        for (String at = destino; at != null; at = prev.get(at)) {
            ruta.addFirst(at);
        }
        return ruta;
    }

    private static class Arista {
        private String destino;
        private double peso;

        public Arista(String destino, double peso) {
            this.destino = destino;
            this.peso = peso;
        }

        public String getDestino() {
            return destino;
        }

        public double getPeso() {
            return peso;
        }
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
