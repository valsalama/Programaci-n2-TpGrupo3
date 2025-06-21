package test;

import sistema.SistemaSubte;
import java.util.List;
import java.util.Arrays;

// Test para verificar todas las funcionalidades
public class TestCompleto {
    
    private SistemaSubte sistema;
    private int testsPasados = 0;
    private int testsTotal = 0;

    public TestCompleto() {
        sistema = new SistemaSubte();
    }

    public static void main(String[] args) {
        TestCompleto suite = new TestCompleto();
        suite.ejecutarTodosLosTests();
    }

    // Ejecuta todos los tests disponibles
    public void ejecutarTodosLosTests() {
        System.out.println("=== SUITE COMPLETA DE TESTS ===\n");

        // Tests básicos
        testExistenciaEstaciones();
        testRutasBasicas();
        testCalculoDistancias();
        testTarifa();
        testCasosEspeciales();
        testRendimiento();

        // Resumen final
        System.out.println("\n=== RESUMEN DE TESTS ===");
        System.out.printf("Tests ejecutados: %d\n", testsTotal);
        System.out.printf("Tests exitosos: %d\n", testsPasados);
        System.out.printf("Tests fallidos: %d\n", testsTotal - testsPasados);
        System.out.printf("Porcentaje de éxito: %.1f%%\n", 
            (testsPasados * 100.0) / testsTotal);
    }

    // Verificar que las estaciones existen
    private void testExistenciaEstaciones() {
        System.out.println("1. TEST: Existencia de estaciones");
        
        String[] estacionesTest = {
            "Peru", "Catedral", "Carlos Pellegrini", 
            "Independencia E", "Congreso de Tucuman"
        };

        for (String estacion : estacionesTest) {
            boolean existe = sistema.existeEstacion(estacion);
            verificarTest("Estación existe: " + estacion, existe);
        }

        // Test estación inexistente
        verificarTest("Estación NO existe: Estacion Fantasma", 
            !sistema.existeEstacion("Estacion Fantasma"));
        
        System.out.println();
    }

    // Rutas básicas entre estaciones
    private void testRutasBasicas() {
        System.out.println("2. TEST: Rutas básicas");

        // Test rutas conocidas
        Object[][] rutasTest = {
            {"Peru", "Catedral", true},
            {"Lima", "Avenida de Mayo", true},
            {"Carlos Pellegrini", "9 de Julio", true},
            {"Congreso de Tucuman", "Independencia E", true},
            {"Estacion Fantasma", "Peru", false}
        };

        for (Object[] test : rutasTest) {
            String origen = (String) test[0];
            String destino = (String) test[1];
            boolean deberiaEncontrar = (Boolean) test[2];
            
            List<String> ruta = sistema.encontrarRutaMinima(origen, destino);
            boolean encontro = (ruta != null && !ruta.isEmpty());
            
            verificarTest(String.format("Ruta %s → %s", origen, destino), 
                encontro == deberiaEncontrar);
        }
        
        System.out.println();
    }

    // Cálculo de distancias
    private void testCalculoDistancias() {
        System.out.println("3. TEST: Cálculo de distancias");

        // Test ruta simple
        List<String> rutaSimple = Arrays.asList("Peru", "Catedral");
        double distancia = sistema.calcularDistanciaRuta(rutaSimple);
        verificarTest("Distancia Peru → Catedral = 0.1 km", 
            Math.abs(distancia - 0.1) < 0.001);

        // Test ruta vacía
        double distanciaVacia = sistema.calcularDistanciaRuta(Arrays.asList());
        verificarTest("Distancia ruta vacía = 0", distanciaVacia == 0);

        // Test ruta null
        double distanciaNull = sistema.calcularDistanciaRuta(null);
        verificarTest("Distancia ruta null = 0", distanciaNull == 0);

        System.out.println();
    }

    // Tarifa del sistema
    private void testTarifa() {
        System.out.println("4. TEST: Tarifa del sistema");
        
        double tarifa = sistema.tarifaFija();
        verificarTest("Tarifa = $890.0", tarifa == 890.0);
        
        System.out.println();
    }

    // Casos especiales
    private void testCasosEspeciales() {
        System.out.println("5. TEST: Casos especiales");

        // Test misma estación
        List<String> rutaMisma = sistema.encontrarRutaMinima("Peru", "Peru");
        verificarTest("Ruta misma estación", 
            rutaMisma != null && rutaMisma.size() == 1);

        // Test estaciones muy lejanas
        List<String> rutaLejana = sistema.encontrarRutaMinima(
            "San Pedrito", "Plaza de los Virreyes - Eva Peron");
        verificarTest("Ruta entre extremos del sistema", 
            rutaLejana != null && rutaLejana.size() > 5);

        System.out.println();
    }

    // Rendimiento básico
    private void testRendimiento() {
        System.out.println("6. TEST: Rendimiento básico");

        long inicio = System.currentTimeMillis();
        
        // Ejecutar varias búsquedas
        for (int i = 0; i < 100; i++) {
            sistema.encontrarRutaMinima("Peru", "Congreso de Tucuman");
        }
        
        long tiempo = System.currentTimeMillis() - inicio;
        verificarTest("100 búsquedas en menos de 1 segundo", tiempo < 1000);
        
        System.out.printf("   Tiempo para 100 búsquedas: %d ms\n", tiempo);
        System.out.println();
    }

    // Método auxiliar para verificar tests
    private void verificarTest(String descripcion, boolean resultado) {
        testsTotal++;
        if (resultado) {
            testsPasados++;
            System.out.println("   ✅ " + descripcion);
        } else {
            System.out.println("   ❌ " + descripcion);
        }
    }
}
