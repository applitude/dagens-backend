package no.applitude.dagensbackend.model;
import java.util.Arrays;

class Location {
    private String address;
    private String place;
    private Dish []dishes;

    public Location(String address, String place){
        this.address = address;
        this.place = place;
    }
    public void add(Dish d){
        dishes = Arrays.copyOf(dishes, dishes.length+1);
        dishes[dishes.length-1] = d;
    }
}
