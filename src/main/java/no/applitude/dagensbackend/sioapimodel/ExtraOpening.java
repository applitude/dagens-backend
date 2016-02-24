package no.applitude.dagensbackend.sioapimodel;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public class ExtraOpening {
	@SerializedName("label")
	private String label;
	
	@SerializedName("openings")
	private HashMap<String,String> openings;

}
