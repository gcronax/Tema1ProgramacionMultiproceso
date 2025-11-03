package pruebas;

public class CuentaBancaria {
    private int saldo;
    public CuentaBancaria(int saldoInicial) {
        this.saldo = saldoInicial;
    }

    private Object lock1= new Object();
    private Object lock2= new Object();


    public int getSaldo() {
        return saldo;
    }
    private synchronized void depositar(int cantidad) {
        saldo += cantidad;
    }
    private synchronized void retirar(int cantidad) {
        saldo -= cantidad;
    }

    public void transferir(CuentaBancaria destino, int cantidad) {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() +
                    " - Bloqueo de cuenta de origen");

            // Pequeña pausa para aumentar la probabilidad de deadlock
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() +
                        " - Bloqueo de cuenta de destino");

                if (saldo >= cantidad) {
                    retirar(cantidad);
                    destino.depositar(cantidad);
                    System.out.println(Thread.currentThread().getName() +
                            " - Transferencia exitosa: " + cantidad);
                } else {
                    System.out.println(Thread.currentThread().getName() +
                            " - Saldo insuficiente");
                }
            }
        }
    }
}
