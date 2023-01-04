package main;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Runner {
	
	static boolean is_over_limit = false;
	
	static boolean is_zero = false;
	
	public static void create_alert(boolean value) {
		Request_maker rm= new Request_maker();
        Alert my_alert= new Alert(123,"title","descr",5,"link","img");
        rm.makePostRequest(my_alert);
        
        if(!value){
        	System.out.println("Uploaded alert correctly");}
        else{
        	System.out.println("Too many alerts");}
	
	}
	
	public static void delete_alerts() {
		Request_maker rm= new Request_maker();
		rm.makeDeleteRequest();
	}
	
	
	public static void delete_status(boolean v){
		if(v){
        	System.out.println("Good Delete");}
        else{
        	System.out.println("Bad Delete");}
	}
	
	public static void main(String[] args) throws IOException, JSONException {
		
        delete_alerts();
		
		for (int i = 0; i<7;i++){
        create_alert(is_over_limit);
        check_limit();
		}
		
		
		delete_alerts();
		check_limit();
		delete_status(is_zero);
       
	}
	
	public static void check_limit() throws IOException, JSONException{
		Request_maker rm= new Request_maker();
		String res = rm.makeEventGetRequest();
        
        JSONArray arr = new JSONArray(res);
        JSONObject my_obj = arr.getJSONObject(0);
        
        int len = my_obj.getJSONObject("systemState").getJSONArray("alerts").length();
        System.out.println("Number of alerts is: "+len);
        
        
        if(len > 5){
        	is_over_limit= true;
        }else if(len == 0){
        	is_zero= true;
        }
        else {is_over_limit = false;}
	}
}