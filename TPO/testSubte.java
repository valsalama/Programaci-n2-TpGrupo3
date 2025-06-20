package test;

import java.util.List;

public class testSubte {
	
	public static void main(String[] args) {
        testGrafoBA test = new testGrafoBA();

        String origen = "Congreso de Tucuman";
        String destino = "Independencia";

        List<String> ruta = test.encontrarRutaMinima(origen, destino);
        if (ruta != null) {
            System.out.println("Ruta mínima de " + origen + " a " + destino + ":");
            for (String estacion : ruta) {
                System.out.println(" - " + estacion);
            }
            System.out.printf("Distancia total: %.2f km\n", test.calcularDistanciaRuta(ruta));
            System.out.printf("Tarifa: $%.2f ARS\n", test.tarifaFija());
        } else {
            System.out.println("No se encontró una ruta entre las estaciones.");
        }
    }

}
