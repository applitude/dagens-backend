package no.applitude.dagensbackend.sioapimodel;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Menu {
	
	@SerializedName("date")
	public String date;
	
	@SerializedName("dinner")
	public List <Dinner> dinner; 
	
	
}
