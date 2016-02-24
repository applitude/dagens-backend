package no.applitude.dagensbackend.model;
import java.util.Arrays;


public class Dish {
    private String title;
    private String[] allergies;
    private String price;
    private boolean veggie;
    

    public Dish (String title, String price, boolean veggie) {
        this.setTitle(title);
        this.setPrice(price);
        this.setVeggie(veggie);
    }
    
    public void add(String s){
        allergies = Arrays.copyOf(allergies, allergies.length+1);
        allergies[allergies.length-1] = s;
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public boolean isVeggie() {
		return veggie;
	}
	public void setVeggie(boolean veggie) {
		this.veggie = veggie;
	}
	
	@Override
	public String toString() {
		String description = String.format("Title:%s Price:%s  Veggie:%b ", this.title, this.price, this.veggie);
		return description;
	}
}
