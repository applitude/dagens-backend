package no.applitude.dagensbackend.sioapimodel;

import com.google.gson.annotations.SerializedName;

public class Menu {
	
	@SerializedName("date")
	private String date;
	
	@SerializedName("dinners")
	private Dinner [] dinners;
	
	
}
