package no.applitude.dagensbackend.apiclient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.nio.charset.Charset;

import no.applitude.dagensbackend.sioapimodel.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SioApiClient {
	private final static String API_ENDPOINT = "https://app.sio.no/api/middag/v1/open/content/restaurants?lang=no";

	public String getApplitudeJsonData () throws MalformedURLException, IOException {
		String jsonString = this.fetchJsonData();
		ArrayList<SioApiModel> deserializedModel = this.deserializeToModel(jsonString);
		ArrayList <HashMap<String, Object>> customApplitudeModel = this.createCustomApplitudeModel(deserializedModel);
	
		HashMap <String, ArrayList <HashMap<String, Object>>> jsonData = new HashMap <String, ArrayList <HashMap<String, Object>>>(); 
		jsonData.put("data", customApplitudeModel);
		
		Gson gson = new Gson();
		String serializeToJson = gson.toJson(jsonData);
		
		return serializeToJson;
	}

	private String fetchJsonData() throws MalformedURLException, IOException {
		String urlString = API_ENDPOINT;

		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();

		InputStream connectionStream = connection.getInputStream();
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connectionStream, "UTF-8"));

		StringBuilder json = new StringBuilder();

		String lineRead;
		while ((lineRead = bufferReader.readLine()) != null) {
			json.append(lineRead);
		}

		return json.toString();
	}

	private ArrayList<SioApiModel> deserializeToModel(String jsonString) {
		Gson gson = new Gson();

		Type typeFromJsonString = new TypeToken<List<SioApiModel>>() {
		}.getType();
		ArrayList<SioApiModel> deserializedToList = gson.fromJson(jsonString, typeFromJsonString);

		return deserializedToList;
	}

	private ArrayList<HashMap<String, Object>> createCustomApplitudeModel(ArrayList<SioApiModel> deserializedData) {

		ArrayList<HashMap<String, Object>> resturantDataList = new ArrayList<HashMap<String, Object>>();

		for (SioApiModel resturant : deserializedData) {
			if (resturant != null) {
				HashMap<String, Object> resturantData = new HashMap<String, Object>();

				String name = resturant.name;
				String house = resturant.house;
				String description = resturant.description;
				String campus = resturant.campus;
				HashMap<String, String>[] stengt = resturant.stengt;
				HashMap<String, String>[] opening = resturant.opening;
				List<ExtraOpening> extraOpening = resturant.extraopening;
				String address = resturant.address;
				String email = resturant.email;
				Float longitude = resturant.longitude;
				Float latitude = resturant.latitude;
				Integer week = resturant.week;

				List<Menu> weeklyMenu = resturant.menu;
				HashMap<String, ArrayList<Dinner>> menuTwoDaysAhead = this.menuTwoDaysAhead(weeklyMenu);

				resturantData.put("name", name);
				resturantData.put("house", house);
				resturantData.put("description", description);
				resturantData.put("campus", campus);
				resturantData.put("stengt", stengt);
				resturantData.put("opening", opening);
				resturantData.put("extraopening", extraOpening);
				resturantData.put("address", address);
				resturantData.put("email", email);
				resturantData.put("longitude", longitude);
				resturantData.put("latitude", latitude);
				resturantData.put("week", week);
				resturantData.put("resturants", menuTwoDaysAhead);

				resturantDataList.add(resturantData);
			}
		}

		return resturantDataList;
	}

	private HashMap<String, ArrayList<Dinner>> menuTwoDaysAhead(List<Menu> weeklyMenu) {
		ArrayList<String> datesOfInterest = this.createDates();
		HashMap<String, ArrayList<Dinner>> menuTwoDaysAhead = new HashMap<String, ArrayList<Dinner>>();

		for (String date : datesOfInterest) {
			menuTwoDaysAhead.put(date, new ArrayList<Dinner>());
		}

		if (weeklyMenu != null) {
			for (Menu menu : weeklyMenu) {
				if (menu != null) {
					for (String date : datesOfInterest) {
						if (date.equalsIgnoreCase(menu.date)) {
							if (menuTwoDaysAhead.containsKey(date)) {
								ArrayList<Dinner> dinnerList = menuTwoDaysAhead.get(date);
								dinnerList.addAll(menu.dinner);
								menuTwoDaysAhead.put(date, dinnerList);
							}
						}
					}
				}
			}
		}
		return menuTwoDaysAhead;
	}
    private String newDate(Calendar cal){
        cal.add(Calendar.DATE, 1);
	
	    if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	        return null;
	    }
	    Date date = cal.getTime();
	    
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    
	    // Using DateFormat format method we can create a string
		// representation of a date with the defined format.
	    String txt = df.format(date);
	    
	    return txt;
	    
	}
	private ArrayList<String> createDates() {
		ArrayList<String> dates = new ArrayList<String>();
		
		Calendar calendar = Calendar.getInstance();
		
		// add next three days
		for(int i=0; i < 3; i++){
			if(newDate(calendar) != null){
		        dates.add(newDate(calendar));
		        calendar.add(Calendar.DATE, 1);
		    }else{
		        //weekend
		        break;
		    }
		}

		return dates;
	}
}
