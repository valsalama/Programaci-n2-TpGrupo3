package test;

import sistema.SistemaSubte;
import java.util.List;
import java.util.Scanner;

// Permite probar diferentes rutas y ver los resultados
public class TestSistemaSubte {
    
    public static void main(String[] args) {
        SistemaSubte sistema = new SistemaSubte();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE SUBTE DE BUENOS AIRES ===");
        System.out.println("Algoritmo de Dijkstra para encontrar rutas óptimas\n");
        
        // Ejemplo predefinido
        ejemploPredefinido(sistema);
        
        // Modo interactivo
        modoInteractivo(sistema, scanner);
        
        scanner.close();
    }
    
    // Ejecuta un ejemplo predefinido para mostrar el funcionamiento
    private static void ejemploPredefinido(SistemaSubte sistema) {
        System.out.println("--- EJEMPLO PREDEFINIDO ---");
        String origen = "Congreso de Tucuman";
        String destino = "Independencia E";
        
        ejecutarBusqueda(sistema, origen, destino);
        System.out.println();
    }
    
    // Permite al usuario ingresar estaciones manualmente
    private static void modoInteractivo(SistemaSubte sistema, Scanner scanner) {
        System.out.println("--- MODO INTERACTIVO ---");
        System.out.println("Ingrese las estaciones (o 'salir' para terminar):");
        
        while (true) {
            System.out.print("\nEstación de origen: ");
            String origen = scanner.nextLine().trim();
            
            if (origen.equalsIgnoreCase("salir")) {
                System.out.println("¡Gracias por usar el sistema!");
                break;
            }
            
            System.out.print("Estación de destino: ");
            String destino = scanner.nextLine().trim();
            
            if (destino.equalsIgnoreCase("salir")) {
                System.out.println("¡Gracias por usar el sistema!");
                break;
            }
            
            ejecutarBusqueda(sistema, origen, destino);
        }
    }
    
    // Ejecuta la búsqueda de ruta y muestra los resultados
    private static void ejecutarBusqueda(SistemaSubte sistema, String origen, String destino) {
        // Verificar que las estaciones existen
        if (!sistema.existeEstacion(origen)) {
            System.out.println("La estación '" + origen + "' no existe en el sistema.");
            return;
        }
        
        if (!sistema.existeEstacion(destino)) {
            System.out.println("La estación '" + destino + "' no existe en el sistema.");
            return;
        }
        
        // Buscar la ruta óptima
        List<String> ruta = sistema.encontrarRutaMinima(origen, destino);
        
        if (ruta != null && !ruta.isEmpty()) {
            System.out.println("RUTA ENCONTRADA:");
            System.out.println("Desde: " + origen);
            System.out.println("Hasta: " + destino);
            System.out.println("\n Recorrido:");
            
            for (int i = 0; i < ruta.size(); i++) {
                String estacion = ruta.get(i);
                if (i == 0) {
                    System.out.println("   🚇 " + estacion + " (ORIGEN)");
                } else if (i == ruta.size() - 1) {
                    System.out.println("   🏁 " + estacion + " (DESTINO)");
                } else {
                    System.out.println("   ↓  " + estacion);
                }
            }
            
            double distancia = sistema.calcularDistanciaRuta(ruta);
            double tarifa = sistema.tarifaFija();
            
            System.out.println("\n INFORMACIÓN DEL VIAJE:");
            System.out.printf("   • Distancia total: %.2f km\n", distancia);
            System.out.printf("   • Número de estaciones: %d\n", ruta.size());
            System.out.printf("   • Transbordos: %d\n", contarTransbordos(ruta));
            System.out.printf("   • Tarifa: $%.2f ARS\n", tarifa);
            
        } else {
            System.out.println("No se encontró una ruta entre las estaciones especificadas.");
        }
    }
    
    // Cuenta aproximadamente los transbordos necesarios
    // (Simplificado - en la realidad sería más complejo)
    private static int contarTransbordos(List<String> ruta) {
        if (ruta.size() <= 2) return 0;
        
        int transbordos = 0;
        for (String estacion : ruta) {
            // Las estaciones de transbordo suelen tener sufijos o nombres específicos
            if (estacion.contains("Independencia") || 
                estacion.contains("Carlos Pellegrini") ||
                estacion.contains("Catedral") ||
                estacion.contains("Peru") ||
                estacion.contains("Lima") ||
                estacion.contains("9 de Julio")) {
                transbordos++;
            }
        }
        return Math.max(0, transbordos - 1); // Restar 1 porque el destino no cuenta como transbordo
    }
}
