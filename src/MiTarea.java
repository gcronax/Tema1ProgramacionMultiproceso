public class MiTarea extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("hilo : "+i+" "+threadId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
