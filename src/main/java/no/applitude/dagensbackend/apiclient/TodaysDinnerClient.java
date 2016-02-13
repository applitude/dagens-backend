package no.applitude.dagensbackend.apiclient;

import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;


public class TodaysDinnerClient {
	private final static String BASE_URL = "https://sio.no/mat-og-drikke/_window/mat+og+drikke+-+dagens+middag?s=";
	private final static String URL_ENDPOINT = "https://sio.no/mat-og-drikke/_window/mat+og+drikke+-+dagens+middag?s=%s";	
	private static ArrayList <String> cafeteriaURLEndpoint;
	
	public TodaysDinnerClient() throws MalformedURLException, IOException {
		this.cafeteriaURLEndpoint = new ArrayList<String>();
		
		this.createCafeteriaURLEndpoint();
		this.getHTML();
	}
	
	private void createCafeteriaURLEndpoint () {
		for (CafeteriaEndpoint element : CafeteriaEndpoint.values()) {
			String endpoint = String.format(URL_ENDPOINT, element.value());
			this.cafeteriaURLEndpoint.add(endpoint);
		}
	}
	
	private String getHTML () throws MalformedURLException, IOException {
		
		String urlString = this.cafeteriaURLEndpoint.get(0);
		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		String htmlResult = "";
		String line;
		
	    while((line = reader.readLine()) != null) {
			htmlResult += line;
		}
	    
	    reader.close();
	    
	    return htmlResult;
	}
	

	private void parseHTMLContent (String html) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
