import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class client {
	public static void main(String[] args) throws Exception{
        URL url = new URL("https://ticket-provider-staging.herokuapp.com/api/v1/tickets/enter");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
        osw.write(String.format("api_token=qMnsbPILS8eIvluTVb1rdg&activity_id=707a6393&user_id=76fb3bd5"));
        osw.flush();
        osw.close();
        System.err.println(connection.getResponseCode());
	}
}
