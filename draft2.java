import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Testes {
    public static void main(String[] args) {
        // create java.util String List bellow
        List<String> list = new ArrayList<>();

        // read shellscript that return a json by curl
        try {
            // Process runtime.getruntime.exec in Windows
            Process process = Runtime.getRuntime().exec("bash check.sh");
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String readline;
            while ((readline = reader.readLine()) != null) {
                //output.append(readline);
                list.add(readline);
                System.out.println(list);
            }

            // Bufferred stderr
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String stderr;
            while ((stderr = stdError.readLine()) != null) {
                System.out.println(stderr);
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}