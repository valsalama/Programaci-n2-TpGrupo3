package test;

import sistema.SistemaSubte;
import java.util.List;

public class TestGrafoBA {

    private SistemaSubte sistema;

    public TestGrafoBA() {
        sistema = new SistemaSubte();
    }

    // Encuentra la ruta mínima entre dos estaciones
    public List<String> encontrarRutaMinima(String origen, String destino) {
        return sistema.encontrarRutaMinima(origen, destino);
    }

    // Calcula la distancia total de una ruta
    public double calcularDistanciaRuta(List<String> ruta) {
        return sistema.calcularDistanciaRuta(ruta);
    }

    // Retorna la tarifa fija del subte
    public double tarifaFija() {
        return sistema.tarifaFija();
    }

    public static void main(String[] args) {
        TestGrafoBA test = new TestGrafoBA();

        String origen = "Congreso de Tucuman";
        String destino = "Independencia E";

        System.out.println("=== TEST GRAFO BUENOS AIRES ===");
        System.out.println("Ejecutando ejemplo original...\n");

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

        System.out.println("\n=== TESTS ADICIONALES ===");
        ejecutarTestsAdicionales(test);
    }

    // Ejecuta varios tests para verificar el funcionamiento
    private static void ejecutarTestsAdicionales(TestGrafoBA test) {
        // Test 1: Ruta dentro de la misma línea
        System.out.println("\n1. Test: Ruta dentro de la misma línea (Línea A)");
        testRuta(test, "San Pedrito", "Peru");

        // Test 2: Ruta con transbordo simple
        System.out.println("\n2. Test: Ruta con transbordo (A → D)");
        testRuta(test, "Lima", "Catedral");

        // Test 3: Ruta más compleja
        System.out.println("\n3. Test: Ruta compleja (B → E)");
        testRuta(test, "Juan Manuel de Rosas", "Plaza de los Virreyes - Eva Peron");

        // Test 4: Ruta corta
        System.out.println("\n4. Test: Ruta muy corta");
        testRuta(test, "Carlos Pellegrini", "9 de Julio");

        // Test 5: Estación inexistente
        System.out.println("\n5. Test: Estación inexistente");
        testRuta(test, "Estacion Fantasma", "Peru");
    }

    // Método auxiliar para ejecutar un test de ruta
    private static void testRuta(TestGrafoBA test, String origen, String destino) {
        List<String> ruta = test.encontrarRutaMinima(origen, destino);
        
        if (ruta != null) {
            System.out.println("✅ " + origen + " → " + destino);
            System.out.println("   Estaciones: " + ruta.size());
            System.out.printf("   Distancia: %.2f km\n", test.calcularDistanciaRuta(ruta));
            
            // Mostrar ruta resumida
            if (ruta.size() <= 5) {
                System.out.println("   Ruta: " + String.join(" → ", ruta));
            } else {
                System.out.println("   Ruta: " + ruta.get(0) + " → ... → " + ruta.get(ruta.size()-1));
            }
        } else {
            System.out.println("❌ " + origen + " → " + destino + " (No encontrada)");
        }
    }
}
