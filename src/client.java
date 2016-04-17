import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class client {
	public static void main(String[] args) throws Exception{
        URL url = new URL("https://ticket-provider-staging.herokuapp.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.write(String.format("even"));
        osw.flush();
        osw.close();
        System.err.println(connection.getResponseCode());
	}
}
