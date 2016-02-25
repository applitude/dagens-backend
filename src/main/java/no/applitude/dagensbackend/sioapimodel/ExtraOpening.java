package no.applitude.dagensbackend.sioapimodel;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

public class ExtraOpening {
	@SerializedName("label")
	String label;
	
	@SerializedName("openings")
	HashMap<String, String> [] openings;

}
