package no.applitude.dagensbackend.apiclient;

import java.util.List;
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
	private static List <SioApiModel> applitudeModel;
	
	public SioApiClient() throws MalformedURLException, IOException {
		this.createApplitudeModel(this.deserialize(this.fetchJsonData()));
	}
		
	private String fetchJsonData () throws MalformedURLException, IOException {
		String urlString = API_ENDPOINT;
		
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		
		InputStream connectionStream = connection.getInputStream();
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connectionStream));

		StringBuilder json = new StringBuilder();
		
		String lineRead;
		while ((lineRead = bufferReader.readLine()) != null) {
			json.append(lineRead);
		}
		
		return json.toString();
	}
	
	private List <SioApiModel> deserialize(String jsonString) {
		Gson gson = new Gson();		
		
		Type typeFromJsonString = new TypeToken<List<SioApiModel>>(){}.getType();
		List <SioApiModel> deserializedToList = gson.fromJson(jsonString, typeFromJsonString);
		
		return deserializedToList;
	}
	
	public List <SioApiModel> createApplitudeModel (List <SioApiModel> deserialized) throws MalformedURLException, IOException {
		
		return null;
	}
}
