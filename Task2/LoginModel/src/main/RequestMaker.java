package main;

import java.io.IOException;
import java.util.Scanner;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.BasicHttpClientResponseHandler;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONObject;

public class RequestMaker{ 
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

