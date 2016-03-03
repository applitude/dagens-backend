package no.applitude.dagensbackend;


import java.io.IOException;
import java.net.MalformedURLException;
import com.amazonaws.util.json.JSONException;
import no.applitude.dagensbackend.apiclient.SioApiClient;
import no.applitude.dagensbackend.apiclient.TodaysDinnerClient;


class Main {
    public static void main(String []args) throws MalformedURLException, IOException, JSONException {
        new TodaysDinnerClient();
        String applitudeJsonData = new SioApiClient().getApplitudeJsonData();
    }


}
