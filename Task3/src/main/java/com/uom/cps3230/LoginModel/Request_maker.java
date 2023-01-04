package com.uom.cps3230.LoginModel;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Request_maker {

    public String makeEventGetRequest() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://api.marketalertum.com/EventsLog/73ed1cab-f8c2-4ff8-84b6-d7f81d835829");
        System.out.println("Executing GET request...");
        HttpResponse response;
        response = httpclient.execute(httpget);
        String responseBody = new BasicResponseHandler().handleResponse(response);
        System.out.println("Response: " + responseBody);
        return responseBody;
    }

    public String makeLoginGetRequest() throws IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet("https://api.marketalertum.com/EventsLog/73ed1cab-f8c2-4ff8-84b6-d7f81d835829/login-status");

        System.out.println("Executing GET request...");
        HttpResponse response;
        response = httpclient.execute(httpget);
        String responseBody = new BasicResponseHandler().handleResponse(response);
        System.out.println("Response: " + responseBody);
        return responseBody;
    }
}
