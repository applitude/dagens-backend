package no.applitude.dagensbackend.apiclient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import no.applitude.dagensbackend.model.Dish;

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
		
		Elements tableTag = htmlDocument.getElementsByClass("inner-spisested");
		
		ArrayList <String> titles = this.selectTitles(tableTag);
		ArrayList <String> contents = this.selectSpans(tableTag); 
		
		this.createDishes(titles, contents);
	}
	
	private void createDishes(ArrayList <String> titles, ArrayList <String> contents) {

		Dish dish = new Dish("", "", false);
		
		for (int i = 0; i<titles.size(); i++) {
			String title = titles.get(i);
			String content = contents.get(i);
			if (title.equalsIgnoreCase("Dagens")) {
				dish.setTitle(content);
			} else if (title.equalsIgnoreCase("Vegetar")) {
				dish.setVeggie(true);
			} else if (title.equalsIgnoreCase("Pris")) {
				dish.setPrice(content);
			}
		}
	}
	

	private ArrayList <String> selectTitles(Elements htmlTable) {
		ArrayList <String> titles = new ArrayList <String>();
		for (Element tag : htmlTable.select("h3")) {
			String name = tag.text();
			titles.add(name);
		}
		return titles;
	}
	
	public ArrayList<String> selectSpans(Elements htmlTable) {
		ArrayList <String> contents = new ArrayList <String>();
		for (Element span : htmlTable.select("span")) {
			String content = span.text();
			contents.add(content);
		}
		return contents;
	}
	
}