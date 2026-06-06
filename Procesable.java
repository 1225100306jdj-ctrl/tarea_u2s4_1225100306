package utng.gtid2.jdj.clases;


public interface Procesable {

    double TASA_SERVICIO = 0.02;

    void procesar(String metodoPago);

    boolean validar();

    String generarRecibo();

    double total();

    default double calcularCargo() {
        return total() * TASA_SERVICIO;
    }

    static String formatearMonto(double m) {
        return String.format("$%.2f", m);
    }
}