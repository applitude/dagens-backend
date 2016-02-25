package no.applitude.dagensbackend.sioapimodel;

import com.google.gson.annotations.SerializedName;

public class Dinner {
	@SerializedName("name")
	public String name;
	
	@SerializedName("type")
	public String type;
	
	@SerializedName("noGluten")
	public boolean noGluten;
	
	@SerializedName("noLactose")
	public boolean noLactose;
}
