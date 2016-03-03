package no.applitude.dagensbackend;

import com.amazonaws.services.lambda.runtime.Context;

public class LambdaHandler{
    public Object handler(Object o, Context c) {
        new AmazonUpload("test-file", "");
        return o;
    }
}
