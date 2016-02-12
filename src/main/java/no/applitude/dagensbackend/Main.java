package no.applitude.dagensbackend;

import com.google.gson.Gson;

class Main{
    public static void main(String []args){
        Gson g = new Gson();
        String []allergies = {"milk", "tomato"};
        System.out.println(g.toJson(new Dish("pizza", "nice pizza", allergies, "55kr", true)));
    }
}
