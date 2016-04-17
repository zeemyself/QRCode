import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class apache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = null;
		try {
			url = new URL("https://ticket-provider-staging.herokuapp.com/api/v1/tickets/exit?api_token=qMnsbPILS8eIvluTVb1rdg&activity_id=707a6393&user_id=76fb3bd5");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("DEBUG1");
//			e.printStackTrace();
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("PUT");
			connection.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("DEBUG2");
//			e.printStackTrace();
		}
		

		InputStream stream;
		try {
			stream = connection.getInputStream();
			System.out.println(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}

}
