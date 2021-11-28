package com.qa.restAPI;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.qa.tempInterface.TemparatureInterface;
import com.qa.ui.testBase.TestBase;

public class APIGetTemp extends TestBase implements TemparatureInterface{
	private String apiUrl = null;
	private String key = null;
		
	public APIGetTemp() {
		// TODO - implement reading these values from config 
		this.apiUrl = "https://api.openweathermap.org/data/2.5/weather";
		this.key = "7fe67bf08c80ded756e598d6f8fedaea";
		
	}
	
	//GET Method
		private int get(String city) throws ClientProtocolException, IOException {
			String url = this.apiUrl+"?q="+city+"&appid="+this.key;
			
			HttpClient httpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			httpClient.execute(httpGet); //hit the get url
			HttpResponse httpResponse = httpClient.execute(httpGet);
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			
			System.out.println("StatusCode "+ statusCode);
			
			String responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
			JSONObject jsonResponse =new JSONObject(responseString);
			
			Double restTemp = jsonResponse.getJSONObject("main").getDouble("temp_min");
			int apiTemp= (int) Math. round(restTemp - 273.15);
			System.out.println(apiTemp);
				
			return apiTemp;
		}

		@Override
		public float getTemperature(String city) {
			float temperature = -1;
			try {
				temperature = this.get(city);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return temperature;
		}
		
		public static void main(String[] args) {
		APIGetTemp apiTemp =new APIGetTemp();
		apiTemp.getTemperature("Bengaluru");
		}
}
