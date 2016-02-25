package no.applitude.dagensbackend.sioapimodel;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import no.applitude.dagensbackend.sioapimodel.ExtraOpening;
import no.applitude.dagensbackend.sioapimodel.Menu;


public class SioApiModel {
	@SerializedName("name")
	public String name;
	
	@SerializedName("house")
	public String house;
	
	@SerializedName("description")
	public String description;
	
	@SerializedName("campus")
	 public String campus;
	
	@SerializedName("stengt")
	 public HashMap<String, String> [] stengt;
	
	@SerializedName("opening")
	 public HashMap<String, String> [] opening;
	
	@SerializedName("extraopening")
	 public List <ExtraOpening> extraopening;
	
	@SerializedName("longitude")
	 public float longitude;
	
	@SerializedName("latitude")
	 public float latitude;
	
	@SerializedName("address")
	 public String address;
	
	@SerializedName("email")
	 public String email;
	
	@SerializedName("telephone")
	 public String telephone;
	
	@SerializedName("week")
	 public int week;
	
	@SerializedName("menu")
	 public List <Menu> menu;
	
}
