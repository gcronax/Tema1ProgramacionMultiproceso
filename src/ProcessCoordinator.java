import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessCoordinator {
    public static void main(String[] args) {
        try {
            System.out.println("ProcessCoordinator PID = " + ProcessHandle.current().pid());

            ProcessBuilder pb = new ProcessBuilder("java", "PingWorker", "0.0.0.0");
            Process worker = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(worker.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("worker -> " + line);
            }
            int exitCode = worker.waitFor();
            System.out.println("se acabo: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
