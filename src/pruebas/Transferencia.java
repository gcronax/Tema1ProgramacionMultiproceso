package pruebas;

public class Transferencia implements Runnable {
    private CuentaBancaria origen;
    private CuentaBancaria destino;
    private int cantidad;
    public Transferencia(CuentaBancaria origen, CuentaBancaria destino, int cantidad) {
        this.origen = origen;
        this.destino = destino;
        this.cantidad = cantidad;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " - Intentando transferir " + cantidad);
        origen.transferir(destino, cantidad);
    }
}
