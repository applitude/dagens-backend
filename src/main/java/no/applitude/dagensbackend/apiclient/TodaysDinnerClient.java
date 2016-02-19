package no.applitude.dagensbackend.apiclient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;


public class TodaysDinnerClient implements DinnerClientInterface {
	private final static String BASE_URL = "https://sio.no/mat-og-drikke/_window/mat+og+drikke+-+dagens+middag?s=";
	private final static String URL_ENDPOINT = "https://sio.no/mat-og-drikke/_window/mat+og+drikke+-+dagens+middag?s=%s";	
	
	public TodaysDinnerClient() throws IOException {
		this.parseHTML();
	}
	
	
	public ArrayList<String> createCafeteriaEndpoint() {
		ArrayList <String> endpoints = new ArrayList <String>();
		for (CafeteriaEndpoint element : CafeteriaEndpoint.values()) {
			String endpoint = String.format(URL_ENDPOINT, element.value());
			endpoints.add(endpoint);
		}
		return endpoints;
	}
	
	private void parseHTML() throws IOException {
		String url = this.createCafeteriaEndpoint().get(0);

		Document htmlDocument = Jsoup.connect(url).get();
		Elements dishes = htmlDocument.getElementsByClass("inner-spisested");
		
		for (Element tag : dishes.select("h3")) {
			this.selectData(tag);
		}		
	}
	
	public void selectData(Element tag) {
		String name = tag.text();
		if (name.equalsIgnoreCase("Dagens")) {
			Elements content = tag.select("span");
			for (Element span : content) {
				String dish = span.text();
				System.out.println(dish);
			}
		
		} else if (name.equalsIgnoreCase("Vegetar")) {
			Elements content = tag.select("span");
			for (Element span : content) {
				String dish = span.text();
				System.out.println(dish);
			}
		
		} else if (name.equalsIgnoreCase("Pris")) {
			Elements content = tag.select("span");
			for (Element span : content) {
				String price = span.text();
				System.out.println(price);
			}
		}
	}
	
	
	
}
