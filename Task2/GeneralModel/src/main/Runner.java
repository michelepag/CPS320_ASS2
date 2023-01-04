package main;

import java.io.IOException;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runner {
	
    public static void main(String[] args) throws JSONException, IOException {
    	
    	List <Integer> events = new ArrayList<Integer>();
        
        
        EventMaker event_maker = new EventMaker();
        
        event_maker.log_in();
        event_maker.view_alerts();
        event_maker.create_alert();
        event_maker.create_alert();
        event_maker.view_alerts();
        event_maker.log_out();
        event_maker.delete_alerts();
        event_maker.log_in();
        event_maker.view_alerts();
        event_maker.close_driver();
        
        events = Event_number();
        System.out.println(events);  
        
        
    }
    
    public static List<Integer> Event_number() throws IOException, JSONException{
    	Request_maker rm= new Request_maker();
        String res = rm.makeEventGetRequest();
        
        List <Integer> events = new ArrayList<Integer>();
        
        JSONArray arr = new JSONArray(res);
        for (int i=0; i < arr.length(); i++){
        	JSONObject obj = arr.getJSONObject(i);
        	int event = obj.getInt("eventLogType");
        	events.add(event);
        }
        return events;
    }
}