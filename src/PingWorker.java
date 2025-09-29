import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PingWorker {
    public static void main(String[] args) {
        String ip;
        if (args.length > 0){
            ip = args[0];
        }else {
            ip="8.8.8.8";
        }

        System.out.println(ip);
        try {
            System.out.println("PingWorker PID = " + ProcessHandle.current().pid());

            ProcessBuilder pb = new ProcessBuilder("ping", ip);
            Process process = pb.start();

            long pingPid = process.pid();
            System.out.println("ping PID = " + pingPid);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("ping -> " + line);
            }

            int exitCode = process.waitFor();
            System.out.println("ping termino: " + exitCode);

            System.exit(exitCode);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}

