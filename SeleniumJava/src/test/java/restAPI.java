import java.io.IOException;
import java.net.http.HttpClient;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class restAPI {

	//GET Method
	public int get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		httpClient.execute(httpGet); //hit the get url
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		
		System.out.println("StatusCode "+ statusCode);
		
		String responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		JSONObject jsonResponse =new JSONObject(responseString);
		
		Double restTemp = jsonResponse.getJSONObject("main").getDouble("temp_max");
		int apiTemp= (int) Math. round(restTemp - 273.15);
		System.out.println(apiTemp);
			
		return apiTemp;
		
	}
}
