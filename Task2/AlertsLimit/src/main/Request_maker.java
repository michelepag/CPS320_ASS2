package main;

import java.io.IOException;
//import java.util.Scanner;

//import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
//import org.apache.hc.core5.http.HttpEntity;
//import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;

public class Request_maker{
	//private CloseableHttpClient httpClient;
	
	/*public Request_maker(){
		httpClient = HttpClients.createDefault();
	}*/
	
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
  	    ClassicHttpResponse response;
	    response = httpclient.execute(httpget);
	    String responseBody = new BasicHttpClientResponseHandler().handleResponse(response);
		System.out.println("Response: " + responseBody);
		return responseBody;
			 
    }
    
    public String makeLoginGetRequest() throws IOException{
    	CloseableHttpClient httpclient = HttpClients.createDefault();
    			
  	    HttpGet httpget = new HttpGet("https://api.marketalertum.com/EventsLog/73ed1cab-f8c2-4ff8-84b6-d7f81d835829/login-status");

  	    System.out.println("Executing GET request...");
  	    ClassicHttpResponse response;
	    response = httpclient.execute(httpget);
		String responseBody = new BasicHttpClientResponseHandler().handleResponse(response);
		System.out.println("Response: " + responseBody);
		return responseBody;
    	
    }
} 