//import java.io.Reader;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class post {

	public static void main(String[] args) throws Exception{
		URL url = null;
		try {
		   url = new URL("https://ticket-provider-staging.herokuapp.com/api/v1/tickets/enter");
		} catch (MalformedURLException exception) {
		    exception.printStackTrace();
		}
		HttpURLConnection httpURLConnection = null;
		DataOutputStream dataOutputStream = null;
		try {
		    httpURLConnection = (HttpURLConnection) url.openConnection();
		    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		    httpURLConnection.setRequestMethod("PUT");
		    httpURLConnection.setDoInput(true);
		    httpURLConnection.setDoOutput(true);
		    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
		    dataOutputStream.writeChars("api_token=qMnsbPILS8eIvluTVb1rdg&activity_id=707a6393&user_id=76fb3bd5");
//		    dataOutputStream.writeChars("fesfsf");
		    System.out.println(httpURLConnection.getResponseCode());
		} catch (IOException exception) {
		    exception.printStackTrace();
		}  finally {
		    if (dataOutputStream != null) {
		        try {
		            dataOutputStream.flush();
		            dataOutputStream.close();
		        } catch (IOException exception) {
		            exception.printStackTrace();
		        }
		    }
		    if (httpURLConnection != null) {
		        httpURLConnection.disconnect();
		    }
		}
	}
}

