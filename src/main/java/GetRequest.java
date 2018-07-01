import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest {

    public String yandexRequest(String str) throws IOException {

        URL obj = new URL(str);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        StringBuffer response ;

        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36");

        try(BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            response = new StringBuffer();

        while((inputLine =in.readLine())!=null)

            {
                response.append(inputLine);
            }
        }

        return response.toString();
    }
}
