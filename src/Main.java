import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.RuntimeMXBean;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        try{
            Process proceso = runtime.exec("ls -l ../");
            BufferedReader reader=new BufferedReader(
                    new InputStreamReader(
                            proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}