package no.applitude.dagensbackend.sioapimodel;

import com.google.gson.annotations.SerializedName;

public class Dinner {
	@SerializedName("name")
	private String name;
	
	@SerializedName("type")
	private String type;
	
	@SerializedName("noGluten")
	private boolean noGluten;
	
	@SerializedName("noLactose")
	private boolean noLactose;
}
