package no.applitude.dagensbackend.apiclient;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import no.applitude.dagensbackend.sioapimodel.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SioApiClient {
	private static String API_ENDPOINT = "https://app.sio.no/api/middag/v1/open/content/restaurants?lang=no";	
	
	public SioApiClient() throws MalformedURLException, IOException {
		this.createModel(this.fetchJsonData());
	}
	
	public String fetchJsonData () throws MalformedURLException, IOException {
		String urlString = API_ENDPOINT;
		
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		
		InputStream connectionStream = connection.getInputStream();
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connectionStream));

		StringBuilder jsonString = new StringBuilder();
		
		String lineRead;
		while ((lineRead = bufferReader.readLine()) != null) {
			jsonString.append(lineRead);
		}
		
		return jsonString.toString();
	}
	
	public void createModel(String jsonString) {
		Gson gson = new Gson();		
		SioApiModel [] test = gson.fromJson(jsonString, SioApiModel[].class);
		System.out.println(test);
		
	}
	
	
	
	
}
