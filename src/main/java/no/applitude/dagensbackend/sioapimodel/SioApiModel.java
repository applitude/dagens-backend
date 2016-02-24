package no.applitude.dagensbackend.sioapimodel;

import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

import no.applitude.dagensbackend.sioapimodel.ExtraOpening;
import no.applitude.dagensbackend.sioapimodel.Menu;


public class SioApiModel {
	@SerializedName("name") 
	private String name;
	
	@SerializedName("house")
	private String house;
	
	@SerializedName("description")
	private String description;
	
	@SerializedName("campus")
	private String campus;
	
	@SerializedName("stengt")
	private HashMap<String,String> [] stengt;
	
	@SerializedName("opening")
	private HashMap<String, String> [] opening;
	
	@SerializedName("extraopening")
	private HashMap<String, ExtraOpening>[] extraopening;
	
	@SerializedName("longitude")
	private int longitude;
	
	@SerializedName("latitude")
	private int latitude;
	
	@SerializedName("address")
	private String address;
	
	@SerializedName("email")
	private String email;
	
	@SerializedName("telephone")
	private String telephone;
	
	@SerializedName("week")
	private int week;
	
	@SerializedName("menu")
	private HashMap <String, Menu> menu;
	
}
