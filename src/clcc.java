import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class clcc {

	public static void main(String[] args) throws Exception {
//		String rawData = "api_token=qMnsbPILS8eIvluTVb1rdg&activity_id=707a6393&user_id=76fb3bd5";
		String type = "application/x-www-form-urlencoded";
//		String encodedData = URLEncoder.encode( rawData ,"UTF-8"); 
		URL u = new URL("https://ticket-provider-staging.herokuapp.com/api/v1/tickets/enter");
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty( "Content-Type", type );
//		conn.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
		conn.addRequestProperty("api_token","qMnsbPILS8eIvluTVb1rdg");
		conn.addRequestProperty("activity_id", "707a6393");
		conn.addRequestProperty("user_id", "76fb3bd5");
		System.out.println(conn.getResponseCode());
//		OutputStream os = conn.getOutputStream();
//		os.write(encodedData.getBytes());
	}

}
