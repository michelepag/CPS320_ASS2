package com.uom.cps3230.AlertLimit;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Request_maker{

    public void sendPost(Alert my_alert) throws Exception {

        HttpPost post = new HttpPost("https://api.marketalertum.com/Alert");
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json");

        JSONObject data = new JSONObject();

        data.put("alertType",my_alert.typeAlert);
        data.put("heading",my_alert.heading);
        data.put("description",my_alert.description);
        data.put("url",my_alert.link);
        data.put("imageUrl",my_alert.img);
        data.put("postedBy",my_alert.user_id);
        data.put("priceInCents",my_alert.price);

        String body = data.toString();

        StringEntity strEnt = new StringEntity(body, ContentType.APPLICATION_JSON);
        post.setEntity(strEnt);


        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }
    }

    public void makePostRequest(Alert my_alert){
        Request_maker obj = new Request_maker();

        System.out.println("Send Http POST request");
        try {
            obj.sendPost(my_alert);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeDeleteRequest(){
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete httpDelete = new HttpDelete("https://api.marketalertum.com/Alert?userId=73ed1cab-f8c2-4ff8-84b6-d7f81d835829");

        try {
            String responseBody = client.execute(httpDelete).toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String makeEventGetRequest() throws IOException{

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
