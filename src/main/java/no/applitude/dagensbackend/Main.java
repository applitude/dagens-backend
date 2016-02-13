package no.applitude.dagensbackend;

import java.io.IOException;
import java.net.MalformedURLException;

import no.applitude.dagensbackend.apiclient.TodaysDinnerClient;
import no.applitude.dagensbackend.model.Dish;

import com.google.gson.Gson;



class Main {
    public static void main(String []args) throws MalformedURLException, IOException{
        Gson g = new Gson();
        String [] allergies = {"milk", "tomato"};
        System.out.println(g.toJson(new Dish("pizza", "nice pizza", allergies, "55kr", true)));
        new TodaysDinnerClient();
    }
}
