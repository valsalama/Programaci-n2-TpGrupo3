package test;

import modelo.Grafo;
import modelo.Vertice;
import java.util.List;

public class testGrafoBA {

    private Grafo grafo;

    public testGrafoBA() {
        grafo = new Grafo();     // inicializa la estructura del grafo
        cargarEstaciones();      // crea los nodos del grafo
        cargarConexiones();      // conecta los nodos con distancias
    }

    private void cargarEstaciones() {
    	//linea A
    	grafo.agregarVertice(new Vertice("San Pedrito"));
    	grafo.agregarVertice(new Vertice("San Jose de Flores"));
    	grafo.agregarVertice(new Vertice("Carabobo"));
    	grafo.agregarVertice(new Vertice("Puan"));
    	grafo.agregarVertice(new Vertice("Primera Junta"));
    	grafo.agregarVertice(new Vertice("Acoyte"));
    	grafo.agregarVertice(new Vertice("Rio de Janeiro"));
    	grafo.agregarVertice(new Vertice("Castro Barros"));
    	grafo.agregarVertice(new Vertice("Loria"));
    	grafo.agregarVertice(new Vertice("Plaza Miserere"));
    	grafo.agregarVertice(new Vertice("Pasco"));
    	grafo.agregarVertice(new Vertice("Alberti"));
    	grafo.agregarVertice(new Vertice("Congreso"));
    	grafo.agregarVertice(new Vertice("Saenz Peña"));
    	grafo.agregarVertice(new Vertice("Lima"));
    	grafo.agregarVertice(new Vertice("Peru"));
    	//linea B
    	grafo.agregarVertice(new Vertice("Juan Manuel de Rosas"));
    	grafo.agregarVertice(new Vertice("Echeverria"));
    	grafo.agregarVertice(new Vertice("Los Incas - Parque Chas"));
    	grafo.agregarVertice(new Vertice("Tronador"));
    	grafo.agregarVertice(new Vertice("Federico Lacroze"));
    	grafo.agregarVertice(new Vertice("Dorrego"));
    	grafo.agregarVertice(new Vertice("Malabia - Osvaldo Pugliese"));
    	grafo.agregarVertice(new Vertice("Angel Gallardo"));
    	grafo.agregarVertice(new Vertice("Medrano"));
    	grafo.agregarVertice(new Vertice("Carlos Gardel"));
    	grafo.agregarVertice(new Vertice("Pueyrredon"));
    	grafo.agregarVertice(new Vertice("Pasteur - AMIA"));
    	grafo.agregarVertice(new Vertice("Callao"));
    	grafo.agregarVertice(new Vertice("Uruguay"));
    	grafo.agregarVertice(new Vertice("Carlos Pellegrini"));
    	grafo.agregarVertice(new Vertice("Florida"));
    	grafo.agregarVertice(new Vertice("Leandro N. Alem"));
    	//linea C
    	grafo.agregarVertice(new Vertice("Retiro"));
    	grafo.agregarVertice(new Vertice("San Martin"));
    	grafo.agregarVertice(new Vertice("Lavalle"));
    	grafo.agregarVertice(new Vertice("Diagonal Norte"));
    	grafo.agregarVertice(new Vertice("Avenida de Mayo"));
    	grafo.agregarVertice(new Vertice("Moreno"));
    	grafo.agregarVertice(new Vertice("Independencia"));
    	grafo.agregarVertice(new Vertice("San Juan"));
    	grafo.agregarVertice(new Vertice("Constitucion"));
    	//linea D
    	grafo.agregarVertice(new Vertice("Catedral"));
    	grafo.agregarVertice(new Vertice("9 de Julio"));
    	grafo.agregarVertice(new Vertice("Tribunales"));
    	grafo.agregarVertice(new Vertice("Callao"));
    	grafo.agregarVertice(new Vertice("Facultad de Medicina"));
    	grafo.agregarVertice(new Vertice("Pueyrredon"));
    	grafo.agregarVertice(new Vertice("Agüero"));
    	grafo.agregarVertice(new Vertice("Bulnes"));
    	grafo.agregarVertice(new Vertice("Scalabrini Ortiz"));
    	grafo.agregarVertice(new Vertice("Palermo"));
    	grafo.agregarVertice(new Vertice("Plaza Italia"));
    	grafo.agregarVertice(new Vertice("Zoo"));
    	grafo.agregarVertice(new Vertice("Ministro Carranza"));
    	grafo.agregarVertice(new Vertice("Olleros"));
    	grafo.agregarVertice(new Vertice("Jose Hernandez"));
    	grafo.agregarVertice(new Vertice("Juramento"));
    	grafo.agregarVertice(new Vertice("Congreso de Tucuman"));
    	//linea E
    	grafo.agregarVertice(new Vertice("Retiro"));
    	grafo.agregarVertice(new Vertice("Catalinas"));
    	grafo.agregarVertice(new Vertice("Correo Central"));
    	grafo.agregarVertice(new Vertice("Bolivar"));
    	grafo.agregarVertice(new Vertice("Belgrano"));
    	grafo.agregarVertice(new Vertice("Independencia"));
    	grafo.agregarVertice(new Vertice("San Jose"));
    	grafo.agregarVertice(new Vertice("Entre Rios - Rodolfo Walsh"));
    	grafo.agregarVertice(new Vertice("Pichincha"));
    	grafo.agregarVertice(new Vertice("Jujuy"));
    	grafo.agregarVertice(new Vertice("Urquiza"));
    	grafo.agregarVertice(new Vertice("Boedo"));
    	grafo.agregarVertice(new Vertice("General Urquiza"));
    	grafo.agregarVertice(new Vertice("Emilio Mitre"));
    	grafo.agregarVertice(new Vertice("Medalla Milagrosa"));
    	grafo.agregarVertice(new Vertice("Varela"));
    	grafo.agregarVertice(new Vertice("Plaza de los Virreyes - Eva Peron"));
    }

    private void cargarConexiones() {
    	//linea A
    	grafo.agregarArista("San Pedrito", "San Jose de Flores", 0.6);
    	grafo.agregarArista("San Jose de Flores", "Carabobo", 0.6);
    	grafo.agregarArista("Carabobo", "Puan", 0.6);
    	grafo.agregarArista("Puan", "Primera Junta", 0.6);
    	grafo.agregarArista("Primera Junta", "Acoyte", 0.6);
    	grafo.agregarArista("Acoyte", "Rio de Janeiro", 0.6);
    	grafo.agregarArista("Rio de Janeiro", "Castro Barros", 0.6);
    	grafo.agregarArista("Castro Barros", "Loria", 0.6);
    	grafo.agregarArista("Loria", "Plaza Miserere", 0.6);
    	grafo.agregarArista("Plaza Miserere", "Pasco", 0.6);
    	grafo.agregarArista("Pasco", "Alberti", 0.6);
    	grafo.agregarArista("Alberti", "Congreso", 0.6);
    	grafo.agregarArista("Congreso", "Saenz Peña", 0.6);
    	grafo.agregarArista("Saenz Peña", "Lima", 0.6);
    	grafo.agregarArista("Lima", "Peru", 0.6);
    	//linea B
    	grafo.agregarArista("Juan Manuel de Rosas", "Echeverria", 0.7);
    	grafo.agregarArista("Echeverria", "Los Incas - Parque Chas", 0.7);
    	grafo.agregarArista("Los Incas - Parque Chas", "Tronador", 0.7);
    	grafo.agregarArista("Tronador", "Federico Lacroze", 0.7);
    	grafo.agregarArista("Federico Lacroze", "Dorrego", 0.7);
    	grafo.agregarArista("Dorrego", "Malabia - Osvaldo Pugliese", 0.7);
    	grafo.agregarArista("Malabia - Osvaldo Pugliese", "Angel Gallardo", 0.7);
    	grafo.agregarArista("Angel Gallardo", "Medrano", 0.7);
    	grafo.agregarArista("Medrano", "Carlos Gardel", 0.7);
    	grafo.agregarArista("Carlos Gardel", "Pueyrredon", 0.7);
    	grafo.agregarArista("Pueyrredon", "Pasteur - AMIA",0.7);
    	grafo.agregarArista("Pasteur - AMIA", "Callao", 0.7);
    	grafo.agregarArista("Callao", "Uruguay", 0.7);
    	grafo.agregarArista("Uruguay", "Carlos Pellegrini", 0.7);
    	grafo.agregarArista("Carlos Pellegrini", "Florida", 0.7);
    	grafo.agregarArista("Florida", "Leandro N. Alem", 0.7);
    	//linea C
    	grafo.agregarArista("Retiro", "San Martin", 0.5);
    	grafo.agregarArista("San Martin", "Lavalle", 0.5);
    	grafo.agregarArista("Lavalle", "Diagonal Norte", 0.5);
    	grafo.agregarArista("Diagonal Norte", "Avenida de Mayo", 0.5);
    	grafo.agregarArista("Avenida de Mayo", "Moreno", 0.5);
    	grafo.agregarArista("Moreno", "Independencia", 0.5);
    	grafo.agregarArista("Independencia", "San Juan", 0.5);
    	grafo.agregarArista("San Juan", "Constitucion", 0.5);
    	//linea D
    	grafo.agregarArista("Catedral", "9 de Julio", 0.65);
    	grafo.agregarArista("9 de Julio", "Tribunales", 0.65);
    	grafo.agregarArista("Tribunales", "Callao", 0.65);
    	grafo.agregarArista("Callao", "Facultad de Medicina", 0.65);
    	grafo.agregarArista("Facultad de Medicina", "Pueyrredon", 0.65);
    	grafo.agregarArista("Pueyrredon", "Agüero", 0.65);
    	grafo.agregarArista("Agüero", "Bulnes", 0.65);
    	grafo.agregarArista("Bulnes", "Scalabrini Ortiz", 0.65);
    	grafo.agregarArista("Scalabrini Ortiz", "Palermo", 0.65);
    	grafo.agregarArista("Palermo", "Plaza Italia", 0.65);
    	grafo.agregarArista("Plaza Italia", "Zoo", 0.65);
    	grafo.agregarArista("Zoo", "Ministro Carranza", 0.65);
    	grafo.agregarArista("Ministro Carranza", "Olleros", 0.65);
    	grafo.agregarArista("Olleros", "Jose Hernandez", 0.65);
    	grafo.agregarArista("Jose Hernandez", "Juramento", 0.65);
    	grafo.agregarArista("Juramento", "Congreso de Tucuman", 0.65);
    	//linea E
    	grafo.agregarArista("Retiro", "Catalinas", 0.66);
    	grafo.agregarArista("Catalinas", "Correo Central", 0.66);
    	grafo.agregarArista("Correo Central", "Bolivar", 0.66);
    	grafo.agregarArista("Bolivar", "Belgrano", 0.66);
    	grafo.agregarArista("Belgrano", "Independencia", 0.66);
    	grafo.agregarArista("Independencia", "San Jose", 0.66);
    	grafo.agregarArista("San Jose", "Entre Rios - Rodolfo Walsh", 0.66);
    	grafo.agregarArista("Entre Rios - Rodolfo Walsh", "Pichincha", 0.66);
    	grafo.agregarArista("Pichincha", "Jujuy", 0.66);
    	grafo.agregarArista("Jujuy", "Urquiza", 0.66);
    	grafo.agregarArista("Urquiza", "Boedo", 0.66);
    	grafo.agregarArista("Boedo", "General Urquiza", 0.66);
    	grafo.agregarArista("General Urquiza", "Emilio Mitre", 0.66);
    	grafo.agregarArista("Emilio Mitre", "Medalla Milagrosa", 0.66);
    	grafo.agregarArista("Medalla Milagrosa", "Varela", 0.66);
    	grafo.agregarArista("Varela", "Plaza de los Virreyes - Eva Peron", 0.66);
    	//conexiones
    	grafo.agregarArista("Catedral", "Peru", 0.1);
    	grafo.agregarArista("Peru", "Catedral", 0.1);
    	grafo.agregarArista("Lima", "Avenida de Mayo", 0.1);
    	grafo.agregarArista("Avenida de Mayo", "Lima", 0.1);
    	grafo.agregarArista("Independencia", "Independencia", 0.1); //comparten nombre A y E
    	grafo.agregarArista("9 de Julio", "Carlos Pellegrini", 0.1);
    	grafo.agregarArista("Carlos Pellegrini", "Diagonal Norte", 0.1);
    	grafo.agregarArista("Diagonal Norte", "9 de Julio", 0.1);

    }

    public List<String> encontrarRutaMinima(String origen, String destino) {
        return grafo.dijkstra(origen, destino);
    }

    public double calcularDistanciaRuta(List<String> ruta) {
        if (ruta == null || ruta.size() < 2) return 0;
        double total = 0;
        for (int i = 0; i < ruta.size() - 1; i++) {
            total += grafo.getPesoArista(ruta.get(i), ruta.get(i + 1));
        }
        return total;
    }

    public double tarifaFija() {
        return 890.0; // tarifa fija 2025
    }

}

