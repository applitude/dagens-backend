package no.applitude.dagensbackend.model;
import java.util.Arrays;

public class Dish {
    private String title;
    private String[] allergies;
    private String price;
    private boolean veggie;

    public Dish (String title, String price, boolean veggie) {
        this.title = title;
        this.price = price;
        this.veggie = veggie;
    }
    public void add(String s){
        allergies = Arrays.copyOf(allergies, allergies.length+1);
        allergies[allergies.length-1] = s;
    }
}
