package pruebas;




public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria(1000);
        CuentaBancaria cuenta2 = new CuentaBancaria(1000);

        System.out.println("=== INICIO DEL PROGRAMA ===");
        System.out.println("Cuenta 1: " + cuenta1.getSaldo());
        System.out.println("Cuenta 2: " + cuenta2.getSaldo());
        System.out.println("\n¡Iniciando transferencias simultáneas!\n");

        // Transferencia 1: de cuenta1 a cuenta2
        Transferencia t1 = new Transferencia(cuenta1, cuenta2, 500);
        Thread hilo1 = new Thread(t1, "Hilo-1");

        // Transferencia 2: de cuenta2 a cuenta1
        Transferencia t2 = new Transferencia(cuenta2, cuenta1, 300);
        Thread hilo2 = new Thread(t2, "Hilo-2");

        // Lanzar ambos hilos al mismo tiempo
        hilo1.start();
        hilo2.start();

        // Esperar a que terminen (o se bloqueen)
        try {
            hilo1.join(5000); // Esperar máximo 5 segundos
            hilo2.join(5000);

            if (hilo1.isAlive() || hilo2.isAlive()) {
                System.out.println("\n¡DEADLOCK DETECTADO!");
                System.out.println("Los hilos están bloqueados.");
                System.out.println("El programa no puede continuar.\n");
                System.exit(0); // Opcional: forzar salida del programa
            } else {
                System.out.println("\n=== TRANSFERENCIAS COMPLETADAS ===");
                System.out.println("Cuenta 1: " + cuenta1.getSaldo());
                System.out.println("Cuenta 2: " + cuenta2.getSaldo());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}