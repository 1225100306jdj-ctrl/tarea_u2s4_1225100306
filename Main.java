package utng.gtid2.jdj.clases;


import java.util.ArrayList;

public class Main {

    public static void procesarTodos(Procesable[] pagos) {

        double totalCobrado = 0;
        double totalCargos = 0;

        for (Procesable pago : pagos) {

            pago.procesar("Efectivo");

            totalCobrado += pago.total();
            totalCargos += pago.calcularCargo();
        }

        System.out.println("\n===== RESUMEN =====");

        System.out.println(
                "Total cobrado: "
                + Procesable.formatearMonto(totalCobrado));

        System.out.println(
                "Total cargos: "
                + Procesable.formatearMonto(totalCargos));
    }

    public static void main(String[] args) {

        ArrayList<Double> materiales1 =
                new ArrayList<>();

        materiales1.add(250.0);
        materiales1.add(300.0);
        materiales1.add(150.0);

        ArrayList<Double> materiales2 =
                new ArrayList<>();

        materiales2.add(500.0);
        materiales2.add(250.0);

        Procesable[] pagos = {

            new PagoInscripcion(
                    "Inscripcion 3A",
                    "2024-08-01",
                    3),

            new PagoInscripcion(
                    "Inscripcion 5A",
                    "2024-08-01",
                    5),

            new PagoMaterial(
                    "Materiales Programacion",
                    "2024-08-02",
                    materiales1),

            new PagoMaterial(
                    "Materiales Redes",
                    "2024-08-03",
                    materiales2),

            new MultaBiblioteca(
                    "Multa Libro Java",
                    "2024-08-05",
                    20,
                    500.0)
        };

        procesarTodos(pagos);
    }
}