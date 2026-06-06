package utng.gtid2.jdj.clases;


public abstract class Pago implements Procesable {

    protected String folio;
    protected String concepto;
    protected String fecha;
    protected boolean pagado;

    private static int contadorFolios = 1;

    public Pago(String concepto, String fecha) {
        this.concepto = concepto;
        this.fecha = fecha;
        this.pagado = false;
        this.folio = String.format("PAG-%03d", contadorFolios++);
    }

    @Override
    public boolean validar() {
        return !pagado;
    }

    @Override
    public String generarRecibo() {
        return folio + " | " + concepto + " | "
                + Procesable.formatearMonto(total());
    }

    @Override
    public void procesar(String metodoPago) {

        if (validar()) {
            pagado = true;

            System.out.println("Metodo de pago: " + metodoPago);
            System.out.println(generarRecibo());

        } else {
            throw new IllegalStateException(
                    "El pago ya fue procesado");
        }
    }

    public String getFolio() {
        return folio;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean isPagado() {
        return pagado;
    }

    @Override
    public abstract double total();
}