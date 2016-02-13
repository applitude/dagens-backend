package no.applitude.dagensbackend;

import java.util.ArrayList;

public class TodaysDinnerRequestHandler {
	private final static String BASE_URL = "https://sio.no/mat-og-drikke/_window/mat+og+drikke+-+dagens+middag?s=";
	private final static String URL_ENDPOINT = "https://sio.no/mat-og-drikke/_window/mat+og+drikke+-+dagens+middag?s=%s";	
	private static ArrayList <String> cafeteriaURLEndpoint;
	
	TodaysDinnerRequestHandler() {
		this.cafeteriaURLEndpoint = new ArrayList<String>();
		this.createCafeteriaURLEndpoint();
	}
	
	
	private void createCafeteriaURLEndpoint () {
		for (CafeteriaEndpoint element : CafeteriaEndpoint.values()) {
			String endpoint = String.format(URL_ENDPOINT, element.value());
			this.cafeteriaURLEndpoint.add(endpoint);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
