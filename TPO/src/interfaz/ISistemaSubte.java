package interfaz;

import java.util.List;

public interface ISistemaSubte {

    public void cargarEstaciones();

    public void cargarConexiones();

    public List<String> encontrarRutaMinima(String origen, String destino);

    public double calcularDistanciaRuta(List<String> ruta);

    public double tarifaFija();
    public boolean existeEstacion(String estacion);

}
