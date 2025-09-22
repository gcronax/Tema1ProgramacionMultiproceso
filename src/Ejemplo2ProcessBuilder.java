import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo2ProcessBuilder {
    public static void main(String[] args) {
        try{
            ProcessBuilder processBuilder = new
                    ProcessBuilder("ping","10.112.4.178");
            Process process= processBuilder.start();
            BufferedReader reader= new BufferedReader(
                    new BufferedReader(new InputStreamReader(
                            process.getInputStream()
                    ))
            );
            String line;
            while ((line= reader.readLine()) !=null){
                System.out.println(line);
            }
            int exintcode =process.waitFor();
            System.out.println("se acabo "+exintcode);

        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
