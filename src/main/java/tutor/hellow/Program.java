package tutor.hellow;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * Created by Bomot on 2016.03.26..
 */
public class Program {
        private static void neo4jRest() throws IOException{
            String query = "{\"statements\":[{\"statement\":\"MATCH (tom {name: \\\"Tom Hanks\\\"}) RETURN tom\",\"resultDataContents\":[\"row\",\"graph\"],\"includeStats\":true}]}";

            HttpURLConnection connection = (HttpURLConnection) new URL("http://localhost:7474/db/data/transaction/commit").openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString("neo4j:neo".getBytes()));
            connection.setDoOutput(true);
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(query.getBytes());
            outputStream.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append('\n');
            }
            reader.close();
            connection.disconnect();

            System.out.println(stringBuilder.toString());

        }
    public static void main(String[] args) {
        Fraction a = new Fraction(2,3);
        Fraction b = new Fraction(5,6);
        Fraction c = Fraction.multiply(a,b);

        System.out.println(c);

    }
}
