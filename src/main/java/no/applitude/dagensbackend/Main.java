package no.applitude.dagensbackend;

import java.io.IOException;
import java.net.MalformedURLException;

import no.applitude.dagensbackend.apiclient.TodaysDinnerClient;
import no.applitude.dagensbackend.model.Dish;

import com.google.gson.Gson;



class Main {
    public static void main(String []args) throws MalformedURLException, IOException {
        Gson g = new Gson();
        new TodaysDinnerClient();
    }


}
