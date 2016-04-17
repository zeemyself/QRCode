import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class clcc {

	public static void main(String[] args) throws Exception {
		String rawData = "user_id = 5";
		String type = "application/json";
		String encodedData = URLEncoder.encode( rawData ,"UTF-8"); 
		URL u = new URL("https://ticket-provider-staging.herokuapp.com");
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty( "Content-Type", type );
		conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
		System.out.println(conn.getResponseCode());
		OutputStream os = conn.getOutputStream();
		os.write(encodedData.getBytes());
	}

}
