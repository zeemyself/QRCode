import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class put2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		DefaultHttpClient httpClient = new DefaultHttpClient();
		URL url = new URL("https://ticket-provider-staging.herokuapp.com/api/v1/tickets/enter");
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("PUT");
		OutputStreamWriter out = new OutputStreamWriter(
		    httpCon.getOutputStream());
		out.write("api_token=qMnsbPILS8eIvluTVb1rdg&activity_id=707a6393&user_id=76fb3bd5");
		out.close();
		httpCon.getInputStream();
	}

}
