package no.applitude.dagensbackend;

import com.amazonaws.services.lambda.runtime.Context;

import no.applitude.dagensbackend.apiclient.SioApiClient;
import no.applitude.dagensbackend.apiclient.TodaysDinnerClient;


public class LambdaHandler{
    public Object handler(Object o, Context c) throws Exception{
        String fileName = "sioapi";
    	String applitudeJsonData = new SioApiClient().getApplitudeJsonData();
    	AmazonUpload uploadFile = new AmazonUpload(fileName, applitudeJsonData);
        return o;
    }
}
